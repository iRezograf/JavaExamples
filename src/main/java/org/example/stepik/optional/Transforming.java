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

        String name = robot.getEngine().get().getName().get();
        System.out.println("name: "+name);

        robot.getEngine().ifPresent(e-> System.out.println("e.getName().toUpperCase(): "+e.getName().get().toUpperCase()));


        System.out.println(transforming.engineNameToUppercase(robot1)); //  Optional.empty
        System.out.println(transforming.engineNameToUppercase(robot));  //  Optional[ENGINE1]

        }
        private Optional<String> engineNameToUppercase(Robot robot){
            return Optional.ofNullable(robot)
                    .flatMap(Robot::getEngine)
                    // returns Optional<Engine>, but pay attention .map(Robot::getEngine) - returns Optional<Optional<Engine>>
                    .flatMap(Engine::getName)
                    .map(n->n.toUpperCase());
    }
/**
 * 1.While Optional provides a lot of improvements, it's easy to misuse it.
 * There are a few pieces of advice that can help you to avoid such mistakes:
 * Avoid returning null. In most cases, the clients of your API expect that the response is safe.
 * Returning null leads to NullPointerException, and it's a bad way to build your API.
 * One option is to return the Optional.empty instead.
 *
 * 2.Don't use Optional as a method parameter. If the method has an Optional parameter,
 * you have to do the unnecessary wrapping and pack an argument into Optional.
 * It leads to low code readability. If the method parameter is optional to have,
 * use overloading instead.
 *
 * 3.In most cases, it's more convenient to use the
 * Optional.map and the Optional.flatMap
 * instead of the Optional.ifPresent
 * to avoid unnecessary if checks.
 *
 * 4.Since Optional is not serializable, don't use it for class fields.
 * The primary design goal of Optional is to be used as the return value of functions
 * when a return value might be absent.
 *
 * 5.Last but not least: keep it simple, don't overuse Optional.
 */
}

class Engine {
    private final String name;

    public Engine(String name) {
        this.name = name;
    }

    public Optional<String> getName() {
        return Optional.ofNullable(name);
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