package com.cloing;

public class ShallowCopy {

    public static void main(String[] args) {
        Foo foo = new Foo("Vijay");

        foo.getName();
        System.out.println(foo.getName());
        Foo foo1 = foo;
        foo.setName("Arun");
        System.out.println(foo1.getName());

    }

    private static class Foo {
        private String name;

        public Foo(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
