    $(document).ready(function(){
      var accueil = true;
      var charte=false;
      var tuto=false;
      $(".tuto").hide();
      $(".charte").hide();
      $(".inscription").hide();
      $(".contact").hide();
              $(".connexion").hide();

      $("#charte").click(function(){

        $(".charte").show();
        $(".accueil").hide();
        $(".tuto").hide();
        $(".inscription").hide();
        $("#inscription").show();
        $( "#charte").classList.add("#menu li:hover");
        $(".contact").hide();
                $(".connexion").hide();


      });
      $("#accueil").click(function(){



        $(".charte").hide();
        $(".accueil").show();
        $(".tuto").hide();
        $(".inscription").hide();
        $("#inscription").show();
        $(".contact").hide();
                $(".connexion").hide();

      });
      $("#tuto").click(function(){


        $(".charte").hide();
        $(".accueil").hide();
        $(".inscription").hide();
        $(".tuto").show();
        $("#inscription").show();
        $(".contact").hide();
        $(".connexion").hide();


      });
      $("#inscription").click(function(){

        $(".charte").hide();
        $(".accueil").hide();
        $(".inscription").show();
        $("#inscription").hide();
        $(".tuto").hide();
        $(".contact").hide();
        $(".connexion").hide();


      });

      $("#contact").click(function(){

        $(".charte").hide();
        $(".accueil").hide();
        $(".inscription").hide();
        $("#inscription").show();
        $(".tuto").hide();
        $(".contact").show();
        $(".connexion").hide();



      });
      $("#connexion").click(function(){

        $(".charte").hide();
        $(".accueil").hide();
        $(".inscription").hide();
        $("#inscription").show();
        $(".tuto").hide();
        $(".contact").hide();
        $(".connexion").show();



      });

    });
