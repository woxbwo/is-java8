package com.is.service.java8.optional;

import org.junit.Test;

import java.util.Optional;

/**
 * @ClassName: OptionalTest2
 * @Description:
 * @Author: Coding_wxb
 * @Date 2019.08.14 16:21
 */
public class OptionalTest2 {
    //获取每个男人心中女神的名字
    @Test
    public void test(){
        Man man = new Man();
        String manGoddnessName = getManGoddnessName(man);

        //2
        Optional<NewMan> op = Optional.ofNullable(null);
        String manGoddnessName2 = getManGoddnessName2(op);
        System.out.println(manGoddnessName2);

        //3
        Optional<Goddness> gdp = Optional.ofNullable(new Goddness("波多野结衣老师"));
        Optional<NewMan> op2 = Optional.ofNullable(new NewMan(gdp));
        String manGoddnessName3 = getManGoddnessName2(op2);
        System.out.println(manGoddnessName3);
    }

    String getManGoddnessName(Man man){
        if(null != man){
            Goddness gd = man.getGoddness();
            if (gd != null) {
                return  gd.getName();
            }
        }
        return "苍老师";
    }
    String getManGoddnessName2(Optional<NewMan> man){
        return man.orElse(new NewMan())
                .getGoddness()
                .orElse(new Goddness("苍老师"))
                .getName();
    }

    class NewMan{
        private Optional<Goddness> goddness = Optional.empty();

        public NewMan(){}

        public NewMan(Optional<Goddness> goddness) {
            this.goddness = goddness;
        }

        public Optional<Goddness> getGoddness() {
            return goddness;
        }

        public void setGoddness(Optional<Goddness> goddness) {
            this.goddness = goddness;
        }
    }

    class Man{
        private Goddness goddness;
        public Man(){

        }

        public Man(Goddness goddness) {
            this.goddness = goddness;
        }

        public Goddness getGoddness() {
            return goddness;
        }

        public void setGoddness(Goddness goddness) {
            this.goddness = goddness;
        }

        @Override
        public String toString() {
            return "Man{" +
                    "goddness=" + goddness +
                    '}';
        }
    }

    class Goddness {
        private String name;

        public Goddness(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Goddness{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

}
