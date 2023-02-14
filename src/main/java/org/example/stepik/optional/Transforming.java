package org.example.stepik.optional;

import java.util.Optional;

public class Transforming {
    public static void main(String[] args) {
        Transforming transforming = new Transforming();

        /**
         Optional.get method that returns a value if it is present,
         otherwise it throws NoSuchElementException:
         */
        Optional<String> version = Optional.of("T1000");
        String stringVersion = version.get();
        System.out.println(stringVersion);

        Robot robot = new Robot(new Engine("engine1"));
        Robot robot1 = new Robot(new Engine(null));

        String name = robot.getEngine().get().getName();
        System.out.println("name: "+name);

        robot.getEngine().ifPresent(e-> System.out.println("e.getName().toUpperCase(): "+e.getName().toUpperCase()));


        System.out.println(transforming.engineNameToUppercase(robot)); // Optional[ENGINE1]
        System.out.println(transforming.engineNameToUppercase(robot).get()); //ENGINE1

        }
        private Optional<String> engineNameToUppercase(Robot robot){
            return Optional.ofNullable(robot)
                    .flatMap(Robot::getEngine) // returns Optional<Engine>, but pay attention .map(Robot::getEngine) - returns Optional<Optional<Engine>>
                    .map(engine -> engine.getName().toUpperCase()); // compilation error
    }
}

class Engine {
    private final String name;

    public Engine(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // a constructor and a getter
}

class Robot {
    private final Engine engine;

    public Robot(Engine engine) {
        this.engine = engine;
    }

    // a constructor

    public Optional<Engine> getEngine() {
        return Optional.ofNullable(engine);
    }
}