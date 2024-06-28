package family_tree;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class FamilyTree extends DateClass   implements Relation {
    private final HashMap<Integer, FamilyTree> familyTree = new HashMap<>();
    private String person="";
    private String relationType="";
    private  String relatedTo="";
    private  Integer id=0;
    private String otvet="";
    private StringBuilder sb=new StringBuilder();
    private Integer key=0;
    private FamilyTree value=null;
    @Override
    public void deb(String pometka, Object obj){
          System.out.println(pometka+obj);
      }
    private FamilyTree(String person,String relationType ,String relatedTo) {
        this.relatedTo = relatedTo;
        this.relationType = relationType;
        this.person = person;
    }

    public FamilyTree() {}
    /**
     * Добавляет родственную связь в базу данных созданной конструктором.
     */
    @Override
    public void addRelation(String person, String relationType, String relatedTo) {

        familyTree.put(id++, new FamilyTree( person, relationType,relatedTo ));
    }



    /**
     * Выводит в консоль ответ относительно одного отношения в любой комбинации из базы данных созданной конструктором.
     */
    @Override
    public void question(String relation) {
        sb.setLength(0);
        otvet="ничего";
        for (Map.Entry<Integer, FamilyTree> entry : familyTree.entrySet()) {
            FamilyTree familyTree = entry.getValue();

            if ( familyTree.person.equals(relation)) {
                sb.append("\n"+familyTree.relationType + "," + familyTree.relatedTo).toString();


            }
            if ( familyTree.relationType.equals(relation)) {
                sb.append("\n"+familyTree.person + "," + familyTree.relatedTo).toString();

            }
            if ( familyTree.relatedTo.equals(relation)) {
                sb.append("\n"+familyTree.person + "," + familyTree.relationType).toString();

            }
        }
        otvet=sb.toString();
       show();

    }



    /**
     * Выводит в консоль ответ относительно двух отношений в любой комбинации из базы данных созданной конструктором.
     */
    @Override
    public void question(String first, String second){
        otvet="ничего";
        sb.setLength(0);
            for (Map.Entry<Integer, FamilyTree> entry : familyTree.entrySet()) {
                FamilyTree familyTree = entry.getValue();

                if (familyTree.person.equals(first) && familyTree.relationType.equals(second)) {
                     sb.append("\n"+familyTree.relatedTo).toString();

                }
                if (familyTree.person.equals(first) && familyTree.relatedTo.equals(second)) {
                    sb.append("\n"+familyTree.relationType).toString();

                }
                if (familyTree.relationType.equals(first) && familyTree.person.equals(second)) {
                    sb.append("\n"+familyTree.relatedTo).toString();

                }
                if (familyTree.relationType.equals(first) && familyTree.relatedTo.equals(second)) {
                    sb.append("\n"+familyTree.person).toString();

                }
                if (familyTree.relatedTo.equals(first) && familyTree.person.equals(second)) {
                    sb.append("\n"+familyTree.relationType).toString();

                }
                if (familyTree.relatedTo.equals(first) && familyTree.relationType.equals(second)) {
                    sb.append("\n"+familyTree.person).toString();

                }

            }
         otvet=sb.toString();
        show();
        }
    /**
     * Выводит в консоль ответ относительно трех отношений в любой комбинации из базы данных созданной конструктором.
     */
    @Override
    public void question(String first, String second, String third) {
        otvet="ничего";
        sb.setLength(0);
        for (Map.Entry<Integer, FamilyTree> entry : familyTree.entrySet()) {
            FamilyTree familyTree = entry.getValue();
            if (familyTree.person.equals(first) && familyTree.relationType.equals(second) && familyTree.relatedTo.equals(third)) {
                sb.append("\n"+"да\n"+familyTree.person+","+familyTree.relationType+","+familyTree.relatedTo).toString();

            }
         }
        otvet=sb.toString();
        show();
    }

    @Override
    public void show() {
       System.out.println(toString());
    }
    @Override
    public String toString() {
        return otvet;
    }
    /**
     * Выводит в консоль содержимое данной базы данных созданной конструктором.
     */
    @Override
    public void showAll() {
        for (Map.Entry<Integer, FamilyTree> entry : familyTree.entrySet()) {
              key = entry.getKey();
              value = entry.getValue();
             System.out.println( key  +", " + value.person + ", " + value.relationType + ", " + value.relatedTo);

        }
    }
    /**
     * Удаляет отношение или отношения по заданному имени или отношению данной базы данных созданной конструктором.
     */
    @Override
    public void deleteRelation(String value) {
        Set<Integer> keysToRemove = new HashSet<>();
        for (Map.Entry<Integer, FamilyTree> entry : familyTree.entrySet()) {
            FamilyTree familyTree = entry.getValue();
            if (familyTree.person.equals(value) || familyTree.relationType.equals(value) || familyTree.relatedTo.equals(value)) {
                keysToRemove.add(entry.getKey());
            }
        }
        for (Integer key : keysToRemove) {
            familyTree.remove(key);
        }
    }


    /**
     * Возвращает родителей данной базы данных созданной конструктором.
     */
    @Override
public void getParents(){
    sb.setLength(0);
    for (Map.Entry<Integer, FamilyTree> entry : familyTree.entrySet()) {
        FamilyTree familyTree = entry.getValue();

        if (familyTree.relationType.equals("дочь") || familyTree.relationType.equals("сын")) {
            sb.append("\n" + familyTree.relatedTo).toString();

        }

    }
        otvet=sb.toString();
        show();

}
    /**
     * Возвращает возраст по заданному имени в данной базе данных созданной конструктором.
     */
    @Override
    public void getAge(String person){

        sb.setLength(0);
        String birth="";
        String die="nothing";
        Integer age=0;
        for (Map.Entry<Integer, FamilyTree> entry : familyTree.entrySet()) {
            FamilyTree familyTree = entry.getValue();

            if (familyTree.person.equals(person) && familyTree.relationType.equals("рожден")) {
                birth=familyTree.relatedTo;


            }
            if (familyTree.person.equals(person) && familyTree.relationType.equals("умерший")) {
                die=familyTree.relatedTo;

            }

        }
        Addon a=new Addon();

        if(a.findTextB(die,"")){age=raznitsaVremeni(birth,die);}
        if(a.findTextB(die,"nothing")){age=calculateAge(birth);}
        otvet=age.toString();
        show();
    }

    /**
     * Возвращает всех детей данной базы данных созданной конструктором.
     */
   @Override
    public void getChildren(){
        sb.setLength(0);
        for (Map.Entry<Integer, FamilyTree> entry : familyTree.entrySet()) {
            FamilyTree familyTree = entry.getValue();

            if (familyTree.relationType.equals("дочь") || familyTree.relationType.equals("сын")) {
                sb.append("\n" + familyTree.person).toString();

            }

        }
        otvet=sb.toString();
        show();

    }


}//конец класса

















