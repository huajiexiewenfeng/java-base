package com.csdn.java.lesson2;

public class CloneableDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Data data = new Data();
        data.setValue(1);
        data.setField(new Field("xwf", "18"));

        Data copy = data.clone();
        //如果是浅拷贝的话 //field -> data.field -> clone -> copy.field
        System.out.println(copy.field == data.field);
        //如果是深拷贝
        System.out.println(copy.field);

    }

    /**
     * 实现 Cloneable 是一个标记接口，用于表示该类可以克隆
     */
    static class Data extends Object implements Cloneable {

        private int value;

        private Field field;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Field getField() {
            return field;
        }

        public void setField(Field field) {
            this.field = field;
        }

        /**
         * 通常吧 protected 访问性提升为 public
         *
         * @return
         * @throws CloneNotSupportedException
         */
        @Override
        public Data clone() throws CloneNotSupportedException {
            //浅copy
//            return (Data) super.clone();
            //深copy
            Data copy = (Data) super.clone();
            copy.field = new Field(field.name, field.value);
            // return ;
            return copy;

        }

    }

    static class Field {
        private String name;
        private String value;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Field(String name, String value) {
            this.name = name;
            this.value = value;
        }


        @Override
        public String toString() {
            return "Field{" +
                    "name='" + name + '\'' +
                    ", value='" + value + '\'' +
                    '}';
        }
    }
}
