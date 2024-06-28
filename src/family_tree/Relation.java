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

      int raznitsaVremeni(String birthDateStr, String deathDateStr);

      long dataConvertToLond(String dateStr);

      void getParents();

      int calculateAge(String birthDateStr);

      void getAge(String person);

      void getChildren();
  }