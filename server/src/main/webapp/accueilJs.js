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

      $("#addPreference").click(function(){
        var str1="";
        var str2="";
        var str3=""; 
        var t= [];
        t.push($("input[name=Casino]:checked").val());
        t.push($("input[name=Cine]:checked").val());
        t.push($("input[name=Golf]:checked").val());
        t.push($("input[name=JeuxSociete]:checked").val());
        t.push($("input[name=Musee]:checked").val());
        t.push($("input[name=Natation]:checked").val());
        t.push($("input[name=Promenade]:checked").val());
        t.push($("input[name=Rando]:checked").val());
        t.push($("input[name=Shopping]:checked").val());
        t.push($("input[name=Tele]:checked").val());
        t.push($("input[name=Tennis]:checked").val());
        t.push($("input[name=Thalasso]:checked").val());
        t.push($("input[name=Velo]:checked").val());
        t.push($("input[name=Zoo]:checked").val());

        var i=0;
        for(i;i<t.length;i++){
          if(t[i].charAt(t[i].length-1)==="1"){
            str1+=t[i]+",";
          }else if(t[i].charAt(t[i].length-1)==="2"){
            str2+=t[i]+",";
          }else{
            str3+=t[i]+",";
          }
        }
        postPreference(str1, str2, str3); 


      });




    });

