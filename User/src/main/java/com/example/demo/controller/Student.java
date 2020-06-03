package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: demo
 * @description:
 * @author: MC
 * @create: 2019-12-26 14:40
 **/
class Student{
    private String name;

    private String position;

    private List<Student> students;

    public Student(String name, String position) {
        this.name = name;
        this.position = position;
        students=new ArrayList<Student>();
    }


    public void add(Student student){
        students.add(student);
    }

    public void remove(Student student){
        students.remove(student);
    }

    public List<Student> get(){
        return students;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", position=" + position + "]";
    }
}


 class CompositeTest {

    public static void main(String[] args) {

        Student studentLeader=new Student("小明","学生会主席");
        Student committeeMember=new Student("小刚","学生会委员");
        Student committeeMember1=new Student("小刚","学生会委员");
        Student student=new Student("小红","学生");

        committeeMember.add(student);
        studentLeader.add(committeeMember);
        studentLeader.add(committeeMember1);
        System.out.println("-"+studentLeader);
        studentLeader.get().forEach(sl->{
            System.out.println("--"+sl);
            sl.get().forEach(cm->{
                System.out.println("---"+cm);
            });
        });
    }
}
