package family_tree;


  interface Relation {

      void deb(String pometka, Object obj);

      abstract void addRelation(String person, String relationType, String relatedTo);

      abstract  void question(String first, String second, String third);

      abstract void question(String first, String second);

      abstract  void question(String first);


      void show();



      void showAll();

      void deleteRelation(String value);





      void getParents();


      void getAge(String person);

      void getChildren();
  }