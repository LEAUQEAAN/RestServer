var INDEX = function () {

    var setData = function(){
        var uls = document.getElementById('tree_1');
        var plunits = document.getElementById('plunits');
        var plunits_1 = document.getElementById('plunits_1');
        //alert(uls);
        var params={};
        $.ajax({
            async: false,
            type: "POST",
            url: "../loadpls",//注意路径
            data: null,
            dataType: "json",
            success: function (data) {
                //alert(JSON.stringify(data, null, 4));
                var str = "<ul>";
                var str1 ='';
                for(var i=0;i< data.length ;i++) {
                    var pol = data[i].policeunit;
                    str1+='<option value="'+pol.policeunit_code+'">'+pol.policeunit_name+'</option>';

                    str += "<li class='ul_li' tabindex='1' id='"+pol.policeunit_code+"' name ='"+pol.policeunit_name+"' data-jstree='{ \"icon\" : \"glyphicon glyphicon-home   icon-state-success \" }'  " +
                        "    > " + pol.policeunit_name;
                    str += '<ul>'
                    var scs = data[i].scenics;
                    for (var j = 0; j < scs.length; j++) {
                        str += "<li tabindex='2' id='"+scs[j].scenic_code+"' name='"+scs[j].scenic_name+"' data-jstree='{\"icon\" : \" glyphicon glyphicon-leaf  icon-state-danger \"}'>" + scs[j].scenic_name;

                        str += "</li>";

                    }
                    str += '</ul>';
                    str += '</li>';


                }
                str += '</ul>';　
                uls.innerHTML = str;
                plunits.innerHTML=str1;
                plunits_1.innerHTML=str1;

　
            },
            error: function (data) {
                swal({
                    title:"数据获取出错！" ,
                    text: "",
                    type: "error",
                    allowOutsideClick: true,
                    showConfirmButton: true,
                    showCancelButton: false,
                    confirmButtonClass: "btn-danger",
                    confirmButtonText: "OK",
                });
            }
        });

    }

    var flag = 1;
    var bindEnvent = function(){
          $("#tree_1").on('changed.jstree', function (e, data) {
              var obj = data.instance.get_node(data.selected[0]);
              //alert(JSON.stringify(data.instance.get_node(data.selected[0]),null,4));
              $("#del_code").val(obj.id);
              if(obj.parent!='#'){
                flag=0;
                  $("#plunits_1").val(obj.parent).trigger("change");
                  $("#sc_code").val(obj.id);
                  $("#sc_name").val(obj.text);

              }else{
                  flag=1;
                  $("#_code").val(obj.id);
                  $("#_name").val(obj.text);
              }
              $("#del_type").val(flag+"");
        }).jstree();

        $("#tree_1").bind("dblclick.jstree", function (e, data) {

            /*alert(JSON.stringify($(e.target),null,4));

            var id = $(e.target).parents('li').attr('id');
            var name = $(e.target).parents('li').attr('name');
             var r = document.getElementById(id) ;
            alert(JSON.stringify(r,null,4));
            //$("#_code").val(id);
            //$("#_name").val(name);*/
            if(flag==0){
                $("#stack4").modal('show');
            }else{
                $("#stack3").modal('show');
            }

        });

        $("#btn_addplu").click(function(){
            //alert($("#plu_add_code").val());
            //alert($("#plu_add_name").val());
            var params={};
            params.code = $("#plu_add_code").val();
            params.name = $("#plu_add_name").val();
            $("#stack1").modal('hide');
            $.ajax({
                async: false,
                type: "POST",
                url: "../addplu",//注意路径
                data: params,
                dataType: "json",
                success: function (data) {
                    if(data){
                        swal({
                            title:"添加成功！" ,
                            text: "",
                            type: "success",
                            allowOutsideClick: true,
                            showConfirmButton: true,
                            showCancelButton: false,
                            confirmButtonClass: "btn-success",
                            confirmButtonText: "OK",
                        },function(value){
                            window.location.reload();
                        });

                    }else{
                        swal({
                            title:"添加失败！" ,
                            text: "",
                            type: "error",
                            allowOutsideClick: true,
                            showConfirmButton: true,
                            showCancelButton: false,
                            confirmButtonClass: "btn-danger",
                            confirmButtonText: "OK",
                        });
                    }

                },
                error: function (data) {
                    swal({
                        title:"添加失败！" ,
                        text: "",
                        type: "error",
                        allowOutsideClick: true,
                        showConfirmButton: true,
                        showCancelButton: false,
                        confirmButtonClass: "btn-danger",
                        confirmButtonText: "OK",
                    });
                }
            });

        });



        $("#btn_add_sce").click(function(){
            alert($("#sce_add_code").val());
            alert($("#sce_add_name").val());
            alert($("#plunits").val());

            $("#stack2").modal('hide');
            var params={};
            params.code = $("#sce_add_code").val();
            params.name = $("#sce_add_name").val();
            params.dept = $("#plunits").val();

            $.ajax({
                async: false,
                type: "POST",
                url: "../addsec",//注意路径
                data: params,
                dataType: "json",
                success: function (data) {
                    if(data){
                        swal({
                            title:"添加成功！" ,
                            text: "",
                            type: "success",
                            allowOutsideClick: true,
                            showConfirmButton: true,
                            showCancelButton: false,
                            confirmButtonClass: "btn-success",
                            confirmButtonText: "OK",
                        },function(value){
                            window.location.reload();
                        });
                    }else{
                        swal({
                            title:"添加失败！" ,
                            text: "",
                            type: "error",
                            allowOutsideClick: true,
                            showConfirmButton: true,
                            showCancelButton: false,
                            confirmButtonClass: "btn-danger",
                            confirmButtonText: "OK",
                        });
                    }

                },
                error: function (data) {
                    swal({
                        title:"添加失败！" ,
                        text: "",
                        type: "error",
                        allowOutsideClick: true,
                        showConfirmButton: true,
                        showCancelButton: false,
                        confirmButtonClass: "btn-danger",
                        confirmButtonText: "OK",
                    });
                }
            });

        });

        $("#btn_alter_plu").click(function(){
            var params={};
            params.code = $("#_code").val();
            params.name = $("#_name").val();
            $("#stack3").modal('hide');
            $.ajax({
                async: false,
                type: "POST",
                url: "../alterplu",//注意路径
                data: params,
                dataType: "json",
                success: function (data) {
                    if(data){
                        swal({
                            title:"修改成功！" ,
                            text: "",
                            type: "success",
                            allowOutsideClick: true,
                            showConfirmButton: true,
                            showCancelButton: false,
                            confirmButtonClass: "btn-success",
                            confirmButtonText: "OK",
                        },function(value){
                            window.location.reload();
                        });
                    }else{
                        swal({
                            title:"修改失败！" ,
                            text: "",
                            type: "error",
                            allowOutsideClick: true,
                            showConfirmButton: true,
                            showCancelButton: false,
                            confirmButtonClass: "btn-danger",
                            confirmButtonText: "OK",
                        });
                    }
                },
                error: function (data) {
                    swal({
                        title:"修改失败！" ,
                        text: "",
                        type: "error",
                        allowOutsideClick: true,
                        showConfirmButton: true,
                        showCancelButton: false,
                        confirmButtonClass: "btn-danger",
                        confirmButtonText: "OK",
                    });
                }
            });

        });

        $("#btn_alter_sce").click(function(){

            var params={};
            params.code = $("#sc_code").val();
            params.name = $("#sc_name").val();
            params.dept = $("#plunits_1").val();
            $("#stack4").modal('hide');
            $.ajax({
                async: false,
                type: "POST",
                url: "../altersec",//注意路径
                data: params,
                dataType: "json",
                success: function (data) {
                    if(data){
                        swal({
                            title:"修改成功！" ,
                            text: "",
                            type: "success",
                            allowOutsideClick: true,
                            showConfirmButton: true,
                            showCancelButton: false,
                            confirmButtonClass: "btn-success",
                            confirmButtonText: "OK",
                        },function(value){
                            window.location.reload();
                        });
                    }else{
                        swal({
                            title:"修改失败！" ,
                            text: "",
                            type: "error",
                            allowOutsideClick: true,
                            showConfirmButton: true,
                            showCancelButton: false,
                            confirmButtonClass: "btn-danger",
                            confirmButtonText: "OK",
                        });
                    }
                },
                error: function (data) {
                    swal({
                        title:"修改失败！" ,
                        text: "",
                        type: "error",
                        allowOutsideClick: true,
                        showConfirmButton: true,
                        showCancelButton: false,
                        confirmButtonClass: "btn-danger",
                        confirmButtonText: "OK",
                    });
                }
            });

        });



        $("#btn_plsc_del").click(function(){
            if($("#del_code").val()=='' || $("#del_type").val()==''){
                swal({
                    title:"请先选择要删除的对象！" ,
                    text: "",
                    type: "info",
                    allowOutsideClick: true,
                    showConfirmButton: true,
                    showCancelButton: false,
                    confirmButtonClass: "btn-danger",
                    confirmButtonText: "OK",
                });
            }

            swal({
                title:"确认删除 ?" ,
                text: "",
                type: "warning",
                allowOutsideClick: true,
                showConfirmButton: true,
                showCancelButton: true,
                confirmButtonClass: "btn-info",
                cancelButtonClass: "btn-danger",
                confirmButtonText: "确认",
                cancelButtonText: "取消",
                closeOnConfirm: false,
                closeOnCancel: true
            },function(isConfirm) {
                if (!isConfirm) return;

                var params={};
                params.code = $("#del_code").val();
                params.type = $("#del_type").val();
                $.ajax({
                    async: false,
                    type: "POST",
                    url: "../plscdel",//注意路径
                    data: params,
                    dataType: "json",
                    success: function (data) {
                        if(data){
                            window.location.reload();
                        }else{
                            swal({
                                title:"删除失败！" ,
                                text: "",
                                type: "error",
                                allowOutsideClick: true,
                                showConfirmButton: true,
                                showCancelButton: false,
                                confirmButtonClass: "btn-danger",
                                confirmButtonText: "OK",
                            });
                        }
                    },
                    error: function (data) {
                        swal({
                            title:"删除失败！",
                            text: "",
                            type: "error",
                            allowOutsideClick: true,
                            showConfirmButton: true,
                            showCancelButton: false,
                            confirmButtonClass: "btn-danger",
                            confirmButtonText: "OK",
                        });
                    }
                });

            });


        });


        $("#btn_logout").click(function() {
            var params = {};
            $.ajax({
                async: false,
                type: "POST",
                url: "../logout",//注意路径
                data: null,
                dataType: "json",
                success: function (data) {
                    window.open("login.jsp", "_self");
                },
                error: function (data) {
                    window.open("login.jsp", "_self");
                }
            });
        });
    }

    var initTable1 = function(){

        var t1 =   document.getElementById('sample_1');
        //alert(t1);
        var params={};
        $.ajax({
            async: false,
            type: "POST",
            url: "../wklist",//注意路径
            data: null,
            dataType: "json",
            success: function (data) {
                 //alert(JSON.stringify(data, null, 4));
                var str ="<thead><tr><th> 身份证号 </th><th> 姓名</th><th> 性别 </th>" +
                    "<th> 所属景区 </th><th> 手机 </th><th> 编辑 </th><th> 删除 </th></tr></thead>";
                for(var i=0;i< data.length ;i++) {

                    str +="<tr>"

                    var wk = data[i].worker;
                    var sc = data[i].scenic;
                    str +="<td>" +wk.worker_code+ "</td>"
                    str +="<td>" +wk.worker_name+ "</td>"
                    str +="<td>" +wk.worker_sex+ "</td>"
                    str +="<td>" +sc.scenic_name+ "</td>"
                    str +="<td>" +wk.worker_phone+ "</td>"

                    str +="<td><a class=\"edit btn btn-outline btn-circle dark  btn-sm   \" href=\"javascript:;\" ><i class='fa fa-edit '></i>修改</a></td>"
                    str +="<td><a class=\"delete btn btn-outline btn-circle dark   btn-sm  \" href=\"javascript:;\"><i class='fa fa-trash-o'></i>删除</a></td>";
                    str +="</tr>"


                }
                str +="<tfoot ><tr><th>  </th><th> </th><th>  </th>" +
                    "<th>  </th><th>  </th><th>  </th><th>  </th></tr></tfoot>";
                t1.innerHTML = str;
            },
            error: function (data) {
                swal({
                    title:"数据获取出错！",
                    text: "",
                    type: "error",
                    allowOutsideClick: true,
                    showConfirmButton: true,
                    showCancelButton: false,
                    confirmButtonClass: "btn-danger",
                    confirmButtonText: "OK",
                });
            }
        });





    }

    var initTable2 = function(){


        var t1 =   document.getElementById('sample_2');
        //alert(t1);
        var params={};
        $.ajax({
            async: false,
            type: "POST",
            url: "../pllist",//注意路径
            data: null,
            dataType: "json",
            success: function (data) {



                //alert(JSON.stringify(data, null, 4));




                var str ="<thead><tr><th> 身份证号 </th><th> 姓名</th><th> 性别 </th>" +
                    "<th> 所属管理单位 </th><th> 手机 </th><th> 编辑 </th><th> 删除 </th></tr></thead>";
                for(var i=0;i< data.length ;i++) {

                    str +="<tr>"

                    var pl = data[i].police;
                    var pu = data[i].policeunit;
                    str +="<td>" +pl.police_code+ "</td>"
                    str +="<td>" +pl.police_name+ "</td>"
                    str +="<td>" +pl.police_sex+ "</td>"
                    str +="<td>" +pu.policeunit_name+ "</td>"
                    str +="<td>" +pl.police_phone+ "</td>"


                    str +="<td><a class=\"edit btn btn-outline btn-circle dark  btn-sm  \" href=\"javascript:;\" ><i class='fa fa-edit'></i>修改</a></td>"
                    str +="<td><a class=\"delete btn btn-outline btn-circle dark  btn-sm  \" href=\"javascript:;\"><i class='fs fs-trash-o'></i>删除</a></td>";
                    str +="</tr>"


                }
                str +="<tfoot ><tr><th>  </th><th> </th><th>  </th>" +
                    "<th>  </th><th>  </th><th>  </th><th>  </th></tr></tfoot>";
                t1.innerHTML = str;
            },
            error: function (data) {
                swal({
                    title:"数据获取出错！",
                    text: "",
                    type: "error",
                    allowOutsideClick: true,
                    showConfirmButton: true,
                    showCancelButton: false,
                    confirmButtonClass: "btn-danger",
                    confirmButtonText: "OK",
                });
            }
        });
    }

    return {　
        init: function () {　
            setData();
            bindEnvent();
            initTable1();
            initTable2();
        }
    };

}();

jQuery(document).ready(function() {
    INDEX.init();
});
