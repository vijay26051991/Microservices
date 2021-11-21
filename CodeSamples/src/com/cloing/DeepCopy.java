package com.cloing;

public class DeepCopy {

    public static void main(String[] args) throws CloneNotSupportedException {
        Foo foo = new Foo();
        foo.setName("Vijay");
        Foo clone = (Foo) foo.clone();
        foo.setName("VijayKumar");
        System.out.println(clone.getName());
        Foo foo1 = new Foo();
        foo1.setName(foo.getName());
    }

    private static class Foo implements Cloneable{
        private String name;

        public Foo() {
        }

        public Foo(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
}
