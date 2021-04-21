$(document).ready(function(){
    var w=window.innerWidth;
    var h=window.innerHeight;
   var tabcount=$(".tabs").find("li").length;
   var len=(w/tabcount);
   
   var delPop=$("#delete");
   
   //tab button part
    var button=$(".tabs").find("button");
    button.css("width",len+"px");
    button.attr("active","false");
    button.first().attr("active","true");
    button.click(function(){
        button.attr("active","false");
        $(this).attr("active","true");
        var tar=$(this).attr("target");
        switch(tar){
            case "tab-1":$(".tab_host").attr("theme","green");$(".RFloat").attr("target","user");
                break;
            case "tab-2":$(".tab_host").attr("theme","blue");$(".RFloat").attr("target","product");
                break;
            case "tab-3":$(".tab_host").attr("theme","margenta");$(".RFloat").attr("target","developer");
                break;
            case "tab-4":$(".tab_host").attr("theme","saffron");$(".RFloat").attr("target","group");
                break;
            default:
        }
        $(".tab_body").attr("visible","false");
        $("#"+tar).attr("visible","true");
    });
    //tab body
    var tabBody=$(".tab_body");
    tabBody.css("width",w-8+"px");
    tabBody.css("height",h-70+"px");
        //table button
        var tButton=tabBody.find("button");
        tButton.click(function(){
        var data=$(this).attr("get").toString();
        var act=$(this).attr("action").toString();
        
        if(data.startsWith("user")){
            var id=$("#"+data).find("ID").html();
            delPop.find(".confim").attr("theme","green");
            if(act==="delete"){
              
              delPop.fadeIn();
              delPop.find("class").html("<u>User</u>");
              delPop.find("ID").html("<u>"+id+"</u>");
              delPop.find("input").attr("value","user");
              delPop.find("input").next().attr("value",id);
            }
            else if(act==="edit"){
                           var name,email,pass,auth;
            name=$("#"+data).find("name").html();
            email=$("#"+data).find("email").html();
            pass=$("#"+data).find("pass").html();
            auth=$("#"+data).find("auth").html();
            
               var inputs=$("#user-update");
               inputs.find("form").attr("action","update");
               inputs.find("[type=submit]").html("update");
               inputs.find("h1").html("Update User");
                    
               inputs.fadeIn();
               inputs.find("[name=id]").val(id);
               inputs.find("[name=name]").val(name);
               inputs.find("[name=email]").val(email);
               inputs.find("[name=pass]").val(pass);
               inputs.find("[name=auth]").val(auth);
               
               inputs.find(".boolean").attr("value",auth);
            }

    }
    else if(data.startsWith("product")){
        var id=$("#"+data).find("ID").html();
        var img=$("#"+data).find("img").attr("src");
        alert(img);
        delPop.find(".confim").attr("theme","blue");
            if(act==="delete"){
              delPop.fadeIn();
              delPop.find("class").html("<u>Product</u>");
              delPop.find("ID").html("<u>"+id+"</u>");
              delPop.find("input").attr("value","product");
              delPop.find("input").next().attr("value",id);
              delPop.find("input").next().next().attr("value",img);
            }
                        else if(act==="edit"){
                           var name,dev,group,cat,date,trend,price,image;
            var tr=$("#"+data).find("td");
            name=$("#"+data).find("name").html();
            dev=$("#"+data).find("dev").html();
            group=$("#"+data).find("group").html();
            cat=$("#"+data).find("category").html();
            date=$("#"+data).find("date").html();
            trend=$("#"+data).find("trend").html();
            price=$("#"+data).find("price").html();
            image=$("#"+data).find("img").attr("src");
            
               var inputs=$("#product-update");
               inputs.find("form").attr("action","update");
               inputs.find("[type=submit]").html("update");
               inputs.find("h1").html("Update Product");
               
               inputs.fadeIn();
               inputs.find("[name=id]").val(id);
               inputs.find("[name=name]").val(name);
               inputs.find("[name=dev]").val(dev);
               var xx=inputs.find("[name=dev]").find("[value="+dev+"]").html();
               inputs.find("[name=dev]").find("span").html(xx);
               inputs.find("[name=group]").val(group);
               var xx=inputs.find("[name=group]").find("[value="+group+"]").html();
               inputs.find("[name=group]").find("span").html(xx);
               inputs.find("[name=date]").val(date);
               inputs.find("[name=imgpath]").val(image);
               inputs.find("[name=category]").val(cat);
               inputs.find("[name=trend]").val(trend);
               inputs.find("[name=price]").val(price);
               alert(image);
               inputs.find("[name=image").attr("value",image);
               
            }
    }else if(data.startsWith("developer")){
        var id=$("#"+data).find("ID").html();
        delPop.find(".confim").attr("theme","margenta");
            if(act==="delete"){
              delPop.fadeIn();
              delPop.find("class").html("<u>Developer</u>");
              delPop.find("ID").html("<u>"+id+"</u>");
              delPop.find("input").attr("value","developer");
              delPop.find("input").next().attr("value",id);
            }else if(act==="edit"){
               var name,desc;
                var tr=$("#"+data).find("td");
            name=$("#"+data).find("name").html();
            desc=$("#"+data).find("desc").html();
              var inputs=$("#developer-update");
               inputs.find("form").attr("action","update");
               inputs.find("[type=submit]").html("update");
               inputs.find("h1").html("Update Developer");
               inputs.fadeIn();
               inputs.find("[name=id]").val(id);
               inputs.find("[name=name]").val(name);
               inputs.find("[name=desc]").val(desc);
            
            }
    }else if(data.startsWith("group")){
        var id=$("#"+data).find("ID").html();
        delPop.find(".confim").attr("theme","saffron");
            if(act==="delete"){
              delPop.fadeIn();
              delPop.find("class").html("<u>Group</u>");
              delPop.find("ID").html("<u>"+id+"</u>");
              delPop.find("input").attr("value","group");
              delPop.find("input").next().attr("value",id);
            }else if(act==="edit"){
                var name,desc;
                var tr=$("#"+data).find("td");
            name=$("#"+data).find("name").html();
            desc=$("#"+data).find("desc").html();
              var inputs=$("#group-update");
               inputs.find("form").attr("action","update");
               inputs.find("[type=submit]").html("update");
               inputs.find("h1").html("Update Group");
               inputs.fadeIn();
               inputs.find("[name=id]").val(id);
               inputs.find("[name=name]").val(name);
               inputs.find("[name=desc]").val(desc);
            }
    }
        });
       
       $(".RFloat").click(function(){
          var target= $(".RFloat").attr("target");
          if(target==="user"){
              var inputs=$("#user-update");
               inputs.fadeIn();
               inputs.find("form").attr("action","insert");
               inputs.find("[name=id]").val("Id will be created itself by database");
               inputs.find("[type=submit]").html("insert");
               inputs.find("h1").html("New User");
          }else
          if(target==="product"){
              var inputs=$("#product-update");
               inputs.fadeIn();
               inputs.find("form").attr("action","insert");
               inputs.find("[name=id]").val("Id will be created itself by database");
               inputs.find("[type=submit]").html("insert");
               inputs.find("h1").html("New Product");
               var dev=50001,group=50001;
               inputs.find("[name=dev]").val(dev);
               var dv=inputs.find("[name=dev]").find("[value="+dev+"]").html();
               
               inputs.find("[name=dev]").find("span").html(dv);
                inputs.find("[name=group]").val(group);
               var gr=inputs.find("[name=group]").find("[value="+group+"]").html();
               inputs.find("[name=group]").find("span").html(gr);
          }else if(target==="developer"){
              var inputs=$("#developer-update");
               inputs.fadeIn();
               inputs.find("form").attr("action","insert");
               inputs.find("[name=id]").val("Id will be created itself by database");
               inputs.find("[type=submit]").html("insert");
               inputs.find("h1").html("New Developer");
          }else if(target==="group"){
              var inputs=$("#group-update");
               inputs.fadeIn();
               inputs.find("form").attr("action","insert");
               inputs.find("[name=id]").val("Id will be created itself by database");
               inputs.find("[type=submit]").html("insert");
               inputs.find("h1").html("New Group");
          }
       });
       
       $(".LFloat").click(function(){
           window.location.href ="log.jsp";
       });
    $(".blur_pop").find("button").click(function(){
        var type=$(this).attr("type").toString();
        if(type==="reset"){
           $(this).parent().parent().parent().fadeOut();
        }
    });
    //boolean box
    $("span.yes").click(function(){
        var boolean=$(this).parent();
        var bool=boolean.attr("value").toString();
        if(bool==="false"){
            boolean.attr("value","true");
            boolean.find("input").attr("value","true");
        }
    });
    $("span.no").click(function(){
        var boolean=$(this).parent();
        
        var bool=boolean.attr("value").toString();
        if(bool==="true"){
            boolean.attr("value","false");
            boolean.find("input").attr("value","false");
        }
    });
    //drop down
    $("div.modified").find("li").click(function(){
        var sel=$(this).html();
        $(this).parent().parent().find("span").html(sel);
        var val=$(this).val().toString();
        $(this).parent().parent().parent().find("select").val(val);
    });
    $("div.modified").click(function(){
        //alert("clicked");
       $(this).toggleClass("active"); 
       $(this).find("ul").slideToggle(); 
    });
    $(window).resize(function(){
        w=window.innerWidth;
        h=window.innerHeight;
        len=(w/tabcount);
    //console.log(w/tabcount);
        button.css("width",len+"px");
        
        tabBody.css("width",w-8+"px");
        tabBody.css("height",h-70+"px");
    });
});