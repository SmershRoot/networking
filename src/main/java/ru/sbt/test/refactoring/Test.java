package ru.sbt.test.refactoring;

public class Test {
    public static void main( String args[] ) {
        Tractor tractor = new Tractor();
       /* System.out.println(tractor.getOrientation().getCode());
        tractor.move("T");
        System.out.println(tractor.getOrientation().getCode());
        tractor.move("T");
        System.out.println(tractor.getOrientation().getCode());
        tractor.move("T");
        System.out.println(tractor.getOrientation().getCode());
        tractor.move("T");
        System.out.println(tractor.getOrientation().getCode());
*/
        System.out.println(tractor.getPositionX());
        System.out.println(tractor.getPositionY());
        tractor.move("F");
        System.out.println(tractor.getPositionX());
        System.out.println(tractor.getPositionY());
        tractor.move("F");
        System.out.println(tractor.getPositionX());
        System.out.println(tractor.getPositionY());
        tractor.move("F");
        System.out.println(tractor.getPositionX());
        System.out.println(tractor.getPositionY());
        tractor.move("T");
        tractor.move("F");
        System.out.println(tractor.getPositionX());
        System.out.println(tractor.getPositionY());
    }
}
