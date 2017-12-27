    var PoliceTable = function () {

    var handleTable = function () {

        var saveok = true;
        var delok = true;

        function restoreRow(oTable, nRow) {
            var aData = oTable.fnGetData(nRow);
            var jqTds = $('>td', nRow);

            for (var i = 0, iLen = jqTds.length; i < iLen; i++) {
                oTable.fnUpdate(aData[i], nRow, i, false);
            }

            oTable.fnDraw();
        }

        function editRow(oTable, nRow) {
            var aData = oTable.fnGetData(nRow);
            var jqTds = $('>td', nRow);
            var str = '';
            $.ajax({
                async: false,
                type: "POST",
                url: "../loadplus",//注意路径
                data: null,
                dataType: "json",
                success: function (data) {
                    // alert(JSON.stringify(data, null, 4));
                    str = '<select style=\"height:25px;padding: 0px;\" class=\"form-control input-small\" >';
                    for(var i=0;i< data.length ;i++) {
                        var itm = data[i];
                        str+='<option value=\"'+itm.policeunit_name+'\" '+(aData[3]== itm.policeunit_name ?'selected =\"selected\"':'') + '>'+itm.policeunit_name+'</option>' ;
                    }
                    str+="</select>"
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
            jqTds[0].innerHTML = '<input type="text" style=\"height:25px;padding: 0px;\" class="form-control input-small" value="' + aData[0] + '">';
            jqTds[1].innerHTML = '<input type="text" style=\"height:25px;padding: 0px;\" class="form-control input-small" value="' + aData[1] + '">';
            //jqTds[2].innerHTML = '<input type="text" style=\"height:25px;padding: 0px;\" class="form-control input-small" value="' + aData[2] + '">';
            jqTds[2].innerHTML = '<select style=\"height:25px;padding: 0px;\" class=\"form-control input-small\" >' +
                '<option value=\"男\" '+(aData[2]=='男'?'selected =\"selected\"':'') + '>男</option>' +
                '<option value=\"女\" '+(aData[2]=='女'?'selected =\"selected\"':'') + '>女</option></select>' ;


            jqTds[3].innerHTML = str;

            //jqTds[3].innerHTML = '<input type="text" style=\"height:25px;padding: 0px;\" class="form-control input-small" value="' + aData[3] + '">';
            jqTds[4].innerHTML = '<input type="text" style=\"height:25px;padding: 0px;\" class="form-control input-small" value="' + aData[4] + '">';
            //jqTds[5].innerHTML = '<a class="edit" href="">Save</a>';
            //jqTds[6].innerHTML = '<a class="cancel" href="">Cancel</a>';

            jqTds[5].innerHTML = '<a class="edit  btn btn-outline btn-circle dark  btn-sm " href=""><i class=\'fa fa-check-circle-o\'></i>保存</a>';
            jqTds[6].innerHTML = '<a class="cancel  btn btn-outline btn-circle dark  btn-sm " href=""><i class=\'fa fa-times-circle-o\'></i>取消</a>';
        }

        function saveRow(oTable, nRow,nNew) {

            var jqInputs = $('input', nRow);
            var jqSelects = $('select', nRow);

            if(jqInputs[0].value=='' || jqInputs[1].value=='' || jqInputs[2].value == ''){
                swal({
                    title:"请输入完整信息！" ,
                    text: "",
                    type: "warning",
                    allowOutsideClick: true,
                    showConfirmButton: true,
                    showCancelButton: false,
                    confirmButtonClass: "btn-danger",
                    confirmButtonText: "OK",
                });
                saveok = false;
                return ;
            }


            saveok = true;
            if(nNew){

                var params={};
                params.code = jqInputs[0].value;
                params.name = jqInputs[1].value;
                params.sex = jqSelects[0].value;
                params.dept = jqSelects[1].value;
                params.phone = jqInputs[2].value;
                //alert(JSON.stringify(params,null,4));
                $.ajax({
                    async: false,
                    type: "POST",
                    url: "../addpolice",//注意路径
                    data: params,
                    dataType: "json",
                    success: function (data) {
                        if(!data){
                            saveok = false;
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
                        saveok = false;
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
            }
            else{
                var params={};
                params.code = jqInputs[0].value;
                params.name = jqInputs[1].value;
                params.sex = jqSelects[0].value;
                params.dept = jqSelects[1].value;
                params.phone = jqInputs[2].value;
                $.ajax({
                    async: false,
                    type: "POST",
                    url: "../alterpolice",//注意路径
                    data: params,
                    dataType: "json",
                    success: function (data) {
                        if(!data){
                            saveok = false;
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
                        saveok = false;
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

            }
            if(!saveok) return ;
            oTable.fnUpdate(jqInputs[0].value, nRow, 0, false);
            oTable.fnUpdate(jqInputs[1].value, nRow, 1, false);
            oTable.fnUpdate(jqSelects[0].value, nRow, 2, false);
            oTable.fnUpdate(jqSelects[1].value, nRow, 3, false);
            oTable.fnUpdate(jqInputs[2].value, nRow, 4, false);
            //oTable.fnUpdate('<a class="edit" href="">Edit</a>', nRow, 5, false);
            //oTable.fnUpdate('<a class="delete" href="">Delete</a>', nRow, 6, false);
            oTable.fnUpdate('<a class="edit  btn btn-outline btn-circle dark  btn-sm "  href=""><i class=\'fa fa-edit\'></i>修改</a>', nRow, 5, false);
            oTable.fnUpdate('<a class="delete  btn btn-outline btn-circle dark  btn-sm " href=""><i class=\'fa fa-trash-o\'></i>删除</a>', nRow, 6, false);
            oTable.fnDraw();
        }

        function cancelEditRow(oTable, nRow) {
            var jqInputs = $('input', nRow);
            var jqSelects = $('select', nRow);
            oTable.fnUpdate(jqInputs[0].value, nRow, 0, false);
            oTable.fnUpdate(jqInputs[1].value, nRow, 1, false);
            oTable.fnUpdate(jqSelects[0].value, nRow, 2, false);
            oTable.fnUpdate(jqSelects[1].value, nRow, 3, false);
            oTable.fnUpdate(jqInputs[2].value, nRow, 4, false);
            //oTable.fnUpdate('<a class="edit" href="">Edit</a>', nRow, 4, false);
            oTable.fnUpdate('<a class="edit" href=""><i class=\'fa fa-edit\'></i>修改</a>', nRow, 5, false);
            oTable.fnDraw();
        }

        var table = $('#sample_2');
        var oTable = table.dataTable({

            // Uncomment below line("dom" parameter) to fix the dropdown overflow issue in the datatable cells. The default datatable layout
            // setup uses scrollable div(table-scrollable) with overflow:auto to enable vertical scroll(see: assets/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.js).
            // So when dropdowns used the scrollable div should be removed.
            //"dom": "<'row'<'col-md-6 col-sm-12'l><'col-md-6 col-sm-12'f>r>t<'row'<'col-md-5 col-sm-12'i><'col-md-7 col-sm-12'p>>",




            "language": {
                "aria": {
                    "sortAscending": ": activate to sort column ascending",
                    "sortDescending": ": activate to sort column descending"
                },
                "emptyTable": "暂时没有获取数据",
                "info": " 显示 _START_ 到 _END_ 条记录，总共 _TOTAL_ 条数据",
                "infoEmpty": "暂时没有获取数据",
                "infoFiltered": "",
                "lengthMenu": "每页  _MENU_ 条数据",
                "search": "筛选:",
                "zeroRecords": "没有匹配到合适的结果"
            },

            buttons: [
                /*{ extend: 'print', className: 'btn dark btn-outline' },
                 { extend: 'copy', className: 'btn red btn-outline' },*/
                /*{ extend: 'pdf', className: 'btn green btn-outline' },*/
                { extend: 'excel', className: 'btn yellow btn-outline ' },
                { extend: 'csv', className: 'btn purple btn-outline ' }
                /*{ extend: 'colvis', className: 'btn dark btn-outline', text: 'Columns'}*/
            ],
            "lengthMenu": [
                [5, 15, 20, -1],
                [5, 15, 20, "All"] // change per page values here
            ],

            // Or you can use remote translation file
            //"language": {
            //   url: '//cdn.datatables.net/plug-ins/3cfcc339e89/i18n/Portuguese.json'
            //},

            // set the initial value
            "pageLength": 5,

            //responsive: true,
            /*"columnDefs": [{ // set default column settings
             'orderable': true,
             'targets': [0]
             }, {
             "searchable": true,
             "targets": [0]
             }],*/
            "order": [
                [0, "asc"]
            ], // set first column as a default sort by asc
            // "dom": "<'row' <'col-md-12'B>><'row'<'col-md-6 col-sm-12'l><'col-md-6 col-sm-12'f>r><'table-scrollable't><'row'<'col-md-5 col-sm-12'i><'col-md-7 col-sm-12'p>>",
        });
        var tableWrapper = $("#sample_editable_2_wrapper");
        var nEditing = null;
        var nNew = false;
        $('#sample_editable_2_new').click(function (e) {
            e.preventDefault();
            if (nNew && nEditing) {
                swal({
                    title:"有未保存数据,确认保存吗?" ,
                    text: "",
                    type: "warning",
                    allowOutsideClick: true,
                    showConfirmButton: true,
                    showCancelButton: true,
                    confirmButtonClass: "btn-info",
                    cancelButtonClass: "btn-danger",
                    confirmButtonText: "确认",
                    cancelButtonText: "取消"
                },function(isConfirm){
                        if (isConfirm){
                            alert(1+"");
                            saveRow(oTable, nEditing,nNew); // save
                            $(nEditing).find("td:first").html("Untitled");
                            nEditing = null;
                            nNew = false;
                        } else {
                            alert(2+"");
                            oTable.fnDeleteRow(nEditing); // cancel
                            nEditing = null;
                            nNew = false;
                            return;
                        }
                    });

                /*if (confirm("有未保存数据,确认保存吗?")) {
                    saveRow(oTable, nEditing,nNew); // save
                    $(nEditing).find("td:first").html("Untitled");
                    nEditing = null;
                    nNew = false;

                } else {
                    oTable.fnDeleteRow(nEditing); // cancel
                    nEditing = null;
                    nNew = false;
                    return;
                }*/
            }else{
                var aiNew = oTable.fnAddData(['', '', '', '', '', '']);
                var nRow = oTable.fnGetNodes(aiNew[0]);
                editRow(oTable, nRow);
                nEditing = nRow;
                nNew = true;
            }

        });
        $('#sample_2_tools > li > a.tool-action').on('click', function() {
            var action = $(this).attr('data-action');
            oTable.DataTable().button(action).trigger();
        });
        table.on('click', '.delete', function (e) {
            e.preventDefault();
            var nRow = $(this).parents('tr')[0];
            var aData = oTable.fnGetData(nRow);
            swal({
                title:"确认删除这一行数据 ?" ,
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
            },function(isConfirm){
                if(!isConfirm) return;
                delok  = true;
                var params={};
                params.code = aData[0];
                $.ajax({
                    async: false,
                    type: "POST",
                    url: "../delpolice",//注意路径
                    data: params,
                    dataType: "json",
                    success: function (data) {
                        if(data){
                            return;
                        }else{
                            delok  = false;
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
                        delok  = false;
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
                });
                if(!delok ) return ;
                oTable.fnDeleteRow(nRow);
                swal({
                    title:"删除成功！" ,
                    text: "",
                    type: "success",
                    allowOutsideClick: true,
                    showConfirmButton: true,
                    showCancelButton: false,
                    confirmButtonClass: "btn-success",
                    confirmButtonText: "OK",
                });
            });

        });

        table.on('click', '.cancel', function (e) {
            e.preventDefault();
            if (nNew) {
                oTable.fnDeleteRow(nEditing);
                nEditing = null;
                nNew = false;
            } else {
                restoreRow(oTable, nEditing);
                nEditing = null;
            }
        });

        table.on('click', '.edit', function (e) {
             e.preventDefault();
            /* Get the row as a parent of the link that was clicked on */
            var nRow = $(this).parents('tr')[0];

           // alert((nEditing == nRow)+"--" + this.innerHTML);
            //alert((nEditing == nRow)+"-"+this.innerHTML);
            if (nEditing !== null && nEditing != nRow) {
                nNew = false;
                /* Currently editing - but not this row - restore the old before continuing to edit mode */
                restoreRow(oTable, nEditing);
                editRow(oTable, nRow);
                nEditing = nRow;
            } else if (nEditing == nRow && this.innerHTML.indexOf("保存")!=-1 ) {
                /* Editing this row and want to save it */

                saveRow(oTable, nEditing,nNew);
                if(saveok){
                    nEditing = null;
                    swal({
                            title:"保存成功！" ,
                            text: "",
                            type: "success",
                            allowOutsideClick: true,
                            showConfirmButton: true,
                            showCancelButton: false,
                            confirmButtonClass: "btn-success",
                            confirmButtonText: "OK",
                        });
                    nNew = false;
                }
            } else {
                nNew = false;
                /* No edit in progress - let's start one */
                editRow(oTable, nRow);
                nEditing = nRow;
            }
        });



    }

    return {

        //main function to initiate the module
        init: function () {
            handleTable();
        }

    };

}();

jQuery(document).ready(function() {
    PoliceTable.init();
});