    $(document).ready(function(){
      $("#profil").hide();
      $("#creeVoyage").hide();
      $("#mesVoyages").hide();
      $("#toutVoyage").hide();
      $(".accueilConnec").hide();
        $(".pageProfil").hide();



      $(".connect").hide(); 
      $(".tuto").hide();
      $(".charte").hide();
      $(".inscription").hide();
      $(".contact").hide();
      $(".connexion").hide();
      $(".pageVoyage").hide();
      $(".profil").hide();

      $("#charte").click(function(){

        $(".charte").show();
        $(".accueil").hide();
        $(".tuto").hide();
        $(".inscription").hide();
        $("#inscription").show();
        $( "#charte").classList.add("#menu li:hover");
        $(".contact").hide();
        $(".connexion").hide();
        $(".pageVoyage").hide();
        $(".profil").hide();



      });
      $("#accueil").click(function(){



        $(".charte").hide();
        $(".accueil").show();
        $(".tuto").hide();
        $(".inscription").hide();
        $("#inscription").show();
        $(".contact").hide();
        $(".connexion").hide();
        $(".pageVoyage").hide();      $(".profil").hide();


      });
      $("#tuto").click(function(){


        $(".charte").hide();
        $(".accueil").hide();
        $(".inscription").hide();
        $(".tuto").show();
        $("#inscription").show();
        $(".contact").hide();
        $(".connexion").hide();
        $(".pageVoyage").hide();
        $(".profil").hide();


      });
      $("#inscription").click(function(){

        $(".charte").hide();
        $(".accueil").hide();
        $(".inscription").show();
        $("#inscription").hide();
        $(".tuto").hide();
        $(".contact").hide();
        $(".connexion").hide();
        $(".pageVoyage").hide();
        $(".profil").hide();


      });

      $("#contact").click(function(){

        $(".charte").hide();
        $(".accueil").hide();
        $(".inscription").hide();
        $("#inscription").show();
        $(".tuto").hide();
        $(".contact").show();
        $(".connexion").hide();
        $(".pageVoyage").hide();
        $(".profil").hide();



      });
      $("#connexion").click(function(){

        $(".charte").hide();
        $(".accueil").hide();
        $(".inscription").hide();
        $("#inscription").hide();
        $(".tuto").hide();
        $(".contact").hide();
        $(".connexion").show();
        $(".pageVoyage").hide();
        $("#connexion").hide();
        $(".profil").hide();
        $(".pageProfil").hide();





      });
      $(".inscription input[name=submit]").click(function(){
       postUser(
        $('.inscription input[name=login]').val(),
        $('.inscription input[name=nom]').val() + " "+$('.inscription input[name=prenom]').val(),
        $('.inscription input[name=email]').val(),
        $('.inscription input[name=password]').val());

       $(".inscription").hide();
       $(".accueil").show();
       $(".pageVoyage").hide();

     });

      $("#submit").click(function(){
        login();
        $("connection").hide();
        $("inscription").hide();
      });

      $("#creeVoyage").click(function(){
        $(".profil").hide();
        $(".pageVoyage").show();
      });
      $("#profil").click(function(){
        $(".pageProfil").hide();
                $(".accueilConnec").show();

        $(".pageVoyage").hide();
        $(".accueil").hide();
        $(".charte").hide();
        $(".contact").hide();
        $(".tuto").hide();


      });

      $("#addVoyage").click(function(){
       postVoyage(
        $('#nomVoyage').val(),
        $('#SelectRegion').val(),
        $('#descrVoyage').val(),
        $('#voyageDep').val(),
        $('#voyageRet').val(),
        $('#CapaciteVoyage').val(),
        "v1/voyages/"
        );
     });
      $("#modifier").click(function(){
        $(".accueilConnec").hide();
        $(".pageProfil").show();


      });




    });

