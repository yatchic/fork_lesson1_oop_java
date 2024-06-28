package ru.gb.vending_machine;

import family_tree.FamilyTree;

public class Main {
    public static void main(String[] args) {
        /*
        Чтобы создать отдельное семейное древо надо создать отдельный конструктор без параметров к классу FamilyTree.
         */

        FamilyTree romanovy = new FamilyTree();

        romanovy.addRelation("Мария", "дочь", "Иван");
        romanovy.addRelation("Иван", "отец", "Мария");
        romanovy.addRelation("Иван", "рожден", "12.08.1956");
        romanovy.addRelation("Мария", "рожден", "13.07.1982");


        FamilyTree petrovy = new FamilyTree();
        petrovy.addRelation("Иван", "сын", "Юлия");
        petrovy.addRelation("Юлия", "рожден", "21.03.1885");
        petrovy.addRelation("Юлия", "умерший", "18.01.1975");
        petrovy.addRelation("Татьяна", "дочь", "Иван");
        petrovy.addRelation("Татьяна", "дочь", "Галина");
        petrovy.addRelation("Елена", "дочь", "Галина");
        petrovy.addRelation("Елена", "дочь", "Иван");
        petrovy.addRelation("Иван", "отец", "Татьяна");
        petrovy.addRelation("Иван", "рожден", "12.08.1956");
        petrovy.addRelation("Татьяна", "рожден", "13.07.1982");

        //petrovy.getChildren();
        //petrovy.getAge("Иван");
         //petrovy.showAll();
        //petrovy.getParents();
        //petrovy.deleteRelation(String value);
         //petrovy.question("Елена", "дочь", "Галина");
         //petrovy.question("Елена", "дочь");
         //petrovy.question("Елена");
     }
}