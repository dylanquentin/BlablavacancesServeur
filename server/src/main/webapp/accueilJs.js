    $(document).ready(function(){
      var accueil = true;
      var charte=false;
      var tuto=false;
      ///

      $(".connect").hide(); //
      ///
      $(".tuto").hide();
      $(".charte").hide();
      $(".inscription").hide();
      $(".contact").hide();
      $(".connexion").hide();
      $(".pageVoyage").hide();

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


      });
      $("#accueil").click(function(){



        $(".charte").hide();
        $(".accueil").show();
        $(".tuto").hide();
        $(".inscription").hide();
        $("#inscription").show();
        $(".contact").hide();
        $(".connexion").hide();
        $(".pageVoyage").hide();

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



      });
      $(".inscription input[name=submit]").click(function(){
       postUser(
        $('.inscription input[name=nom]').val(),
        $('.inscription input[name=login]').val(),
        $('.inscription input[name=email]').val(),
        $('.inscription input[name=password]').val())

       $(".inscription").hide();
       $(".accueil").show();
       $(".pageVoyage").hide();

     });

      $("#submit").click(function(){
        login();
        $("connection").hide();
        $("inscription").hide();
        $(".profil").append("Login : "+login+ " name = "+name);


      });

    });

