<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<!-- BEGIN HEAD -->
<head>
    <meta charset="utf-8" />
    <title>EHelpAndE119管理系统</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1" name="viewport" />
    <meta content="Preview page of Metronic Admin Theme #3 for user inbox" name="description" />
    <meta content="" name="author" />
    <!-- BEGIN GLOBAL MANDATORY STYLES -->
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet" type="text/css" />
    <link href="../assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <link href="../assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css" />
    <link href="../assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="../assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css" />
    <!-- END GLOBAL MANDATORY STYLES -->
    <!-- BEGIN PAGE LEVEL PLUGINS -->
    <link href="../assets/global/plugins/fancybox/source/jquery.fancybox.css" rel="stylesheet" type="text/css" />
    <link href="../assets/global/plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.css" rel="stylesheet" type="text/css" />
    <link href="../assets/global/plugins/jquery-file-upload/blueimp-gallery/blueimp-gallery.min.css" rel="stylesheet" type="text/css" />
    <link href="../assets/global/plugins/jquery-file-upload/css/jquery.fileupload.css" rel="stylesheet" type="text/css" />
    <link href="../assets/global/plugins/jquery-file-upload/css/jquery.fileupload-ui.css" rel="stylesheet" type="text/css" />
    <!-- END PAGE LEVEL PLUGINS -->
    <!-- BEGIN THEME GLOBAL STYLES -->
    <link href="../assets/global/css/components.min.css" rel="stylesheet" id="style_components" type="text/css" />
    <link href="../assets/global/plugins/jstree/dist/themes/default/style.min.css" rel="stylesheet" type="text/css" />
    <link href="../assets/global/css/plugins.min.css" rel="stylesheet" type="text/css" />
    <!-- END THEME GLOBAL STYLES -->
    <!-- BEGIN PAGE LEVEL PLUGINS -->
    <link href="../assets/global/plugins/bootstrap-modal/css/bootstrap-modal-bs3patch.css" rel="stylesheet" type="text/css" />
    <link href="../assets/global/plugins/bootstrap-modal/css/bootstrap-modal.css" rel="stylesheet" type="text/css" />
    <!-- END PAGE LEVEL PLUGINS -->
    <!-- BEGIN PAGE LEVEL STYLES -->
    <link href="../assets/apps/css/inbox.min.css" rel="stylesheet" type="text/css" />
    <!-- END PAGE LEVEL STYLES -->
    <link href="../assets/global/plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.css" rel="stylesheet" type="text/css" />
    <link href="../assets/global/plugins/bootstrap-markdown/css/bootstrap-markdown.min.css" rel="stylesheet" type="text/css" />
    <link href="../assets/global/plugins/bootstrap-summernote/summernote.css" rel="stylesheet" type="text/css" />


   <!--         <link href="../assets/global/plugins/bootstrap-datepicker/css/bootstrap-datepicker3.min.css" rel="stylesheet" type="text/css" /> -->
    <!-- BEGIN THEME LAYOUT STYLES -->

    <link href="../assets/layouts/layout3/css/layout.min.css" rel="stylesheet" type="text/css" />
    <link href="../assets/layouts/layout3/css/themes/default.min.css" rel="stylesheet" type="text/css" id="style_color" />
    <link href="../assets/layouts/layout3/css/custom.min.css" rel="stylesheet" type="text/css" />

    <link href="../assets/global/plugins/bootstrap-select/css/bootstrap-select.min.css" rel="stylesheet" type="text/css" />
    <link href="../assets/global/plugins/datatables/datatables.min.css" rel="stylesheet" type="text/css" />
    <link href="../assets/global/plugins/datatables/plugins/bootstrap/datatables.bootstrap.css" rel="stylesheet" type="text/css" />
    <link href="../assets/global/plugins/select2/css/select2.min.css" rel="stylesheet" type="text/css" />
    <link href="../assets/global/plugins/select2/css/select2-bootstrap.min.css" rel="stylesheet" type="text/css" />

    <link href="../assets/global/plugins/bootstrap-sweetalert/sweetalert.css" rel="stylesheet" type="text/css" />
    <!-- END THEME LAYOUT STYLES -->
    <link rel="shortcut icon" href="favicon.ico" />

    <style type="text/css">
        @media only screen and (min-width: 180px) and (max-width: 767px){
            #info{padding:5px 0px 5px 0px;}

            #info1{padding:0px 0px 0px 0px;}
        }
    </style>
</head>
<!-- END HEAD -->

<body class="page-container-bg-solid"  >

<div class="page-wrapper">
    <div class="page-wrapper-row">
        <div class="page-wrapper-top">
            <!-- BEGIN HEADER -->
            <div class="page-header" style="height:80px;">
                <div class="page-header-top">
                    <div class="container">
                        <div class="page-logo">
                            <a href="index.jsp">
                                <img src="../assets/layouts/layout3/img/logo-default.jpg " alt="logo" class="logo-default">
                            </a>
                        </div>
                        <div class="top-menu">

                            <ul class="nav navbar-nav pull-right">
                                <!-- BEGIN USER LOGIN DROPDOWN -->
                                <li class="dropdown dropdown-user dropdown-dark">
                                    <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
                                        <img alt="" class="img-circle" src="../assets/layouts/layout3/img/avatar9.jpg">
                                        <span class="username username-hide-mobile">${sessionScope.admin.name}</span>
                                    </a>
                                    <ul class="dropdown-menu dropdown-menu-default">
                                        <li>
                                            <a href="page_user_profile_1.html">
                                                <i class="icon-user"></i> My Profile </a>
                                        </li>
                                        <li>
                                            <a href="app_calendar.html">
                                                <i class="icon-calendar"></i> My Calendar </a>
                                        </li>
                                        <li>
                                            <a href="app_inbox.html">
                                                <i class="icon-envelope-open"></i> My Inbox
                                                <span class="badge badge-danger"> 3 </span>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="app_todo_2.html">
                                                <i class="icon-rocket"></i> My Tasks
                                                <span class="badge badge-success"> 7 </span>
                                            </a>
                                        </li>
                                        <li class="divider"> </li>
                                        <li>
                                            <a href="page_user_lock_1.html">
                                                <i class="icon-lock"></i> Lock Screen </a>
                                        </li>
                                        <li>
                                            <a href="page_user_login_1.html">
                                                <i class="icon-key"></i> Log Out </a>
                                        </li>
                                    </ul>
                                </li>
                                <!-- END USER LOGIN DROPDOWN -->
                                <!-- BEGIN QUICK SIDEBAR TOGGLER -->
                                <li class="dropdown dropdown-extended quick-sidebar-toggler" id="btn_logout">
                                    <i class="icon-logout " ></i>
                                </li>
                                <!-- END QUICK SIDEBAR TOGGLER -->
                            </ul>
                        </div>

                    </div>
                </div>
            </div>
            <!-- END HEADER -->
        </div>
    </div>

    <div class="page-wrapper-row full-height">
        <div class="page-wrapper-middle">
            <!-- BEGIN CONTAINER -->
            <div class="page-container">
                <!-- BEGIN CONTENT -->
                <div class="page-content-wrapper">

                    <div class="page-content ">
                        <div class="container">
                            <!-- BEGIN PAGE CONTENT INNER -->
                            <div class="page-content-inner ">
                                <div class="inbox " >
                                    <div class="row"  >
                                        <div class="col-md-3" style="background-color:white;" style="padding:5px 0px 5px 0px;">
                                            <!-- <div class="inbox-sidebar">
                                                <a href="javascript:;" data-title="Compose" class="btn red compose-btn btn-block">
                                                    <i class="fa fa-home"></i>
                                                    &nbsp;&nbsp;管理主页 </a>
                                                <ul class="inbox-nav">
                                                    <li class="active">
                                                        <a href="#tab_6_2" data-toggle="tab"  data-type="inbox" data-title="Inbox"> 单位机构管理
                                                            <span class="badge badge-success">></span>
                                                        </a>
                                                    </li>
                                                    <li class="divider"></li>
                                                    <li>
                                                        <a href="#tab_6_1" data-toggle="tab"  data-title="Trash"> 安保人员管理
                                                            <span class="badge badge-success">></span>
                                                        </a>
                                                    </li>
                                                    <li>
                                                        <a href="#tab_6_6" data-toggle="tab" data-type="inbox" data-title="Promotions"> 安保人员添加
                                                            <span class="badge badge-danger">></span>
                                                        </a>
                                                    </li>
                                                    <li class="divider"></li>
                                                    <li>
                                                        <a href="#tab_6_7" data-toggle="tab" data-title="Trash"> 警务人员管理
                                                            <span class="badge badge-success">></span>
                                                        </a>
                                                    </li>
                                                    <li>
                                                        <a href="#tab_6_8" data-toggle="tab" data-type="inbox" data-title="Promotions">警务人员添加
                                                            <span class="badge badge-danger">></span>
                                                        </a>
                                                    </li>
                                                </ul>
                                            </div> -->
                                            <div class="portlet light ">
                                                <div class="portlet-title">
                                                    <div class="caption">
                                                        <i class="icon-social-dribbble font-blue-sharp"></i>
                                                        <span class="caption-subject font-blue-sharp bold uppercase">单位结构</span>
                                                    </div>
                                                    <div class="actions">
                                                        <a class="btn btn-circle btn-icon-only btn-default" id="btn_plsc_del" href="javascript:;">
                                                            <i class="icon-trash"></i>
                                                            <input type="hidden" id="del_code" value=""/>
                                                            <input type="hidden" id="del_type" value=""/>
                                                        </a>

                                                        <div class="btn-group  dropdown">
                                                            <a class="btn   green rounded btn-outline  dropdown-toggle" type="button" data-toggle="dropdown">
                                                                <i class="fa fa-plus"></i>
                                                            </a>
                                                           <%-- <a class="btn btn-circle   btn-default"  data-toggle="dropdown" href="javascript:;">
                                                                <i class="fa fa-plus"></i>
                                                            </a>--%>
                                                            <ul class="dropdown-menu pull-right" role="menu">
                                                                <li>
                                                                    <a href="javascript:;"   data-target="#stack1" data-toggle="modal" ><i class="fa fa-plus"></i>&nbsp;&nbsp;添加管理单位 </a>
                                                                </li>
                                                                <li>
                                                                    <a href="javascript:;"  data-target="#stack2" data-toggle="modal"><i class="fa fa-plus"></i>&nbsp;&nbsp;添加景区单位</a>
                                                                </li>
                                                            </ul>
                                                        </div>
                                                        <%--<a class="btn btn-circle btn-icon-only btn-default"   data-target="#stack1" data-toggle="modal"  href="javascript:;">
                                                            <i class="fa fa-plus"></i>
                                                        </a>
                                                        <a class="btn btn-circle btn-icon-only btn-default" style="text-align: center;" data-target="#stack2" data-toggle="modal"  href="javascript:;">
                                                            <i class="glyphicon glyphicon-plus"></i>
                                                        </a>
                                                        <a class="btn btn-circle btn-icon-only btn-default" data-target="#stack3" data-toggle="modal"  href="javascript:;">
                                                            <i class="icon-pencil"></i>
                                                        </a>--%>

                                                    </div>
                                                </div>
                                                <div class="portlet-body">
                                                    <div id="tree_1" class="tree-demo">
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div id="info" class="col-md-9"  >
                                            <div class="inbox-body">
                                                <div class="inbox-content" >
                                                    <div id="info1" class="tab-content" >
                                                        <div class="portlet-body"  >
                                                            <div class="tabbable-line"  >
                                                                <ul class="nav nav-tabs ">
                                                                    <li class="active">
                                                                        <a href="#tab_15_1" data-toggle="tab"> 景区人员 </a>
                                                                    </li>
                                                                    <li>
                                                                        <a href="#tab_15_2" data-toggle="tab"> 接警人员 </a>
                                                                    </li>
                                                                    <li>
                                                                        <a href="#tab_15_3" data-toggle="tab"> 资讯信息 </a>
                                                                    </li>
                                                                </ul>
                                                                <div class="tab-content" style="min-height:500px;padding-top:0px;">
                                                                    <div class="tab-pane active" id="tab_15_1">
                                                                        <div class="row">
                                                                            <div class="col-md-12">
                                                                                <div class="portlet light " >
                                                                                <div class="portlet-body">
                                                                                <div class="table-toolbar">
                                                                                    <div class="row">
                                                                                        <div class="col-md-6 col-sm-6 col-xs-6">
                                                                                            <div class="btn-group">
                                                                                                <button id="sample_editable_1_new" class="btn btn-circle red ">
                                                                                                    <i class="fa fa-plus"></i>&nbsp;&nbsp;新增
                                                                                                </button>
                                                                                            </div>
                                                                                        </div>
                                                                                        <div class="actions">
                                                                                            <div class="btn-group " style="float: right;margin-right:15px;">
                                                                                                <a class="btn red btn-outline btn-circle" href="javascript:;" data-toggle="dropdown">
                                                                                                    <i class="fa fa-share"></i>
                                                                                                    <span class="hidden-xs"> 数据导出 </span>
                                                                                                    <i class="fa fa-angle-down"></i>
                                                                                                </a>
                                                                                                <ul class="dropdown-menu pull-right" id="sample_1_tools">
                                                                                                    <li>
                                                                                                        <a href="javascript:;" data-action="0" class="tool-action">
                                                                                                            <i class="icon-paper-clip"></i> 导出Excel数据文本</a>
                                                                                                    </li>
                                                                                                    <li>
                                                                                                        <a href="javascript:;" data-action="1" class="tool-action">
                                                                                                            <i class="icon-cloud-upload"></i> 导出CSV数据文本</a>
                                                                                                    </li>

                                                                                                    </li>
                                                                                                </ul>
                                                                                            </div>
                                                                                        </div>
                                                                                    </div>
                                                                                </div>
                                                                                <table class="table table-striped table-hover table-bordered" id="sample_1">

                                                                                </table>
                                                                            </div>
                                                                            </div>

                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                    <div class="tab-pane" id="tab_15_2">
                                                                        <div class="row">
                                                                            <div class="col-md-12">
                                                                                <div class="portlet light " >
                                                                                    <div class="portlet-body">
                                                                                        <div class="table-toolbar">
                                                                                            <div class="row">
                                                                                                <div class="col-md-6 col-sm-6 col-xs-6">
                                                                                                    <div class="btn-group">
                                                                                                        <button id="sample_editable_2_new" class="btn btn-circle red ">
                                                                                                            <i class="fa fa-plus"></i>&nbsp;&nbsp;新增
                                                                                                        </button>
                                                                                                    </div>
                                                                                                </div>
                                                                                                <div class="actions">
                                                                                                    <div class="btn-group " style="float: right;margin-right:15px;">
                                                                                                        <a class="btn red btn-outline btn-circle" href="javascript:;" data-toggle="dropdown">
                                                                                                            <i class="fa fa-share"></i>
                                                                                                            <span class="hidden-xs"> 数据导出 </span>
                                                                                                            <i class="fa fa-angle-down"></i>
                                                                                                        </a>
                                                                                                        <ul class="dropdown-menu pull-right" id="sample_2_tools">
                                                                                                            <li>
                                                                                                                <a href="javascript:;" data-action="0" class="tool-action">
                                                                                                                    <i class="icon-paper-clip"></i> 导出Excel数据文本</a>
                                                                                                            </li>
                                                                                                            <li>
                                                                                                                <a href="javascript:;" data-action="1" class="tool-action">
                                                                                                                    <i class="icon-cloud-upload"></i> 导出CSV数据文本</a>
                                                                                                            </li>

                                                                                                            </li>
                                                                                                        </ul>
                                                                                                    </div>
                                                                                                </div>
                                                                                            </div>
                                                                                        </div>
                                                                                        <table class="table table-striped table-hover table-bordered" id="sample_2">

                                                                                        </table>
                                                                                    </div>
                                                                                </div>

                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                    <div class="tab-pane" id="tab_15_3">
                                                                        <div class="portlet-body form">
                                                                            <div class="form-horizontal">
                                                                                <div class="form-body">
                                                                                    <div class="form-group last">
                                                                                        <div class="col-md-12">
                                                                                            <div name="summernote" id="summernote_1"> </div>
                                                                                        </div>
                                                                                    </div>
                                                                                    <div class="row">
                                                                                        <div class="col-md-12">
                                                                                            <a id="btn_put" class="btn btn-block green">
                                                                                                <i class="fa fa-check"></i>发布资讯
                                                                                            </a>
                                                                                        </div>
                                                                                    </div>
                                                                                    <textarea id="text_res" style="height:900px;width:100%;" >



                                                                                    </textarea>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- END PAGE CONTENT INNER -->
                        </div>
                    </div>
                    <!-- END PAGE CONTENT BODY -->
                    <!-- END CONTENT BODY -->
                </div>
                <!-- END CONTENT -->

            </div>
            <!-- END CONTAINER -->
        </div>
    </div>


    <div class="page-wrapper-row">
        <div class="page-wrapper-bottom" >
            <!-- BEGIN FOOTER -->
            <!-- BEGIN PRE-FOOTER -->
            <div class="page-prefooter" style="background-color:#FFFFFF;">
                <div class="container">
                    <div class="row">
                        <div class="col-md-3 col-sm-6 col-xs-12 footer-block">
                            <h2>About</h2>
                            <p> Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam dolore. </p>
                        </div>
                        <div class="col-md-3 col-sm-6 col-xs12 footer-block">
                            <h2>Subscribe Email</h2>
                            <div class="subscribe-form">
                                <form action="javascript:;">
                                    <div class="input-group">
                                        <input type="text" placeholder="mail@email.com" class="form-control">
                                                <span class="input-group-btn">
                                                    <button class="btn" type="submit">Submit</button>
                                                </span>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <div class="col-md-3 col-sm-6 col-xs-12 footer-block">
                            <h2>Follow Us On</h2>
                            <ul class="social-icons">
                                <li>
                                    <a href="javascript:;" data-original-title="rss" class="rss"></a>
                                </li>
                                <li>
                                    <a href="javascript:;" data-original-title="facebook" class="facebook"></a>
                                </li>
                                <li>
                                    <a href="javascript:;" data-original-title="twitter" class="twitter"></a>
                                </li>
                                <li>
                                    <a href="javascript:;" data-original-title="googleplus" class="googleplus"></a>
                                </li>
                                <li>
                                    <a href="javascript:;" data-original-title="linkedin" class="linkedin"></a>
                                </li>
                                <li>
                                    <a href="javascript:;" data-original-title="youtube" class="youtube"></a>
                                </li>
                                <li>
                                    <a href="javascript:;" data-original-title="vimeo" class="vimeo"></a>
                                </li>
                            </ul>
                        </div>
                        <div class="col-md-3 col-sm-6 col-xs-12 footer-block">
                            <h2>Contacts</h2>
                            <address class="margin-bottom-40"> Phone: 800 123 3456
                                <br> Email:
                                <a href="mailto:info@metronic.com">info@metronic.com</a>
                            </address>
                        </div>
                    </div>
                </div>
            </div>
            <!-- END PRE-FOOTER -->
            <!-- BEGIN INNER FOOTER -->
            <div class="page-footer" style="background-color:#EFF3F8;">
                <div class="container"> 2016 &copy; Metronic Theme By
                    <a target="_blank" style="color:#CBBDC7;" href="http://keenthemes.com">Keenthemes</a> &nbsp;|&nbsp;
                    <a href="http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes" title="Purchase Metronic just for 27$ and get lifetime updates for free" target="_blank"  style="color:#CBBDC7;">Purchase Metronic!</a>
                </div>
            </div>
            <div class="scroll-to-top">
                <i class="icon-arrow-up"></i>
            </div>
            <!-- END INNER FOOTER -->
            <!-- END FOOTER -->
        </div>
    </div>


    <div id="stack1" class="modal fade" tabindex="-1" data-focus-on="input:first">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <h4 class="modal-title"><i class="fa fa-plus"></i>&nbsp;&nbsp;添加管理单位</h4>
        </div>
        <div class="modal-body">
            <div class="form-group">
                <input class="form-control"   placeholder="输入管理单位编号" type="text" id="plu_add_code" data-tabindex="1"> </div>
            <div class="form-group">
                <input class="form-control"  placeholder="输入管理单位名称" type="text" id="plu_add_name" data-tabindex="2"> </div>
        </div>
        <div class="modal-footer">
            <button type="button" class="btn green" id="btn_addplu"><i class="fa fa-plus"></i>&nbsp;&nbsp; 确认</button>
            <button type="button" data-dismiss="modal" class="btn btn-outline dark"><i class="fa fa-times-circle"></i>&nbsp;&nbsp;取消</button>
        </div>
    </div>

    <div id="stack2" class="modal fade" tabindex="-1" data-focus-on="input:first">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <h4 class="modal-title"><i class="fa fa-plus"></i>&nbsp;&nbsp;添加景区单位</h4>
        </div>
        <div class="modal-body">
            <div class="form-group">
                <%--<select class="bs-select form-control" id="plunits" data-style="btn-default" data-tabindex="1">
                    <option>Mustard</option>
                    <option>Ketchup</option>
                    <option>Relish</option>
                </select>--%>
                <div class="input-group select2-bootstrap-prepend">
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="button" data-select2-open="single-prepend-text">
                            <span class="glyphicon glyphicon-home green"></span>
                        </button>
                    </span>
                    <select id="plunits"  class="form-control select2">
                        <option></option>
                        <option value="A">A</option>
                        <option value="B">B</option>
                        <option value="C">C</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <input class="form-control" id="sce_add_code" placeholder="输入景区编号" type="text" data-tabindex="2"> </div>
            <div class="form-group">
                <input class="form-control" id="sce_add_name" placeholder="输入景区名称" type="text" data-tabindex="3"> </div>
        </div>
        <div class="modal-footer">
            <button type="button" id="btn_add_sce" class="btn green"><i class="fa fa-plus"></i>&nbsp;&nbsp;确认</button>
            <button type="button" data-dismiss="modal" class="btn btn-outline dark"><i class="fa fa-times-circle"></i>&nbsp;&nbsp;取消</button>

        </div>
    </div>

    <div id="stack3" class="modal fade" tabindex="-1" data-focus-on="input:first">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <h4 class="modal-title"><i class="icon-pencil"></i>&nbsp;&nbsp;修改信息</h4>
        </div>
        <div class="modal-body">
            <div class="form-group">
                <input class="form-control" readonly id="_code" type="hidden" data-tabindex="1"> </div>
            <div class="form-group">
                <input class="form-control" id="_name" type="text" data-tabindex="2"> </div>
        </div>
        <div class="modal-footer">
            <button type="button" id="btn_alter_plu" class="btn green"><i class="fa fa-pencil"></i>&nbsp;&nbsp;确认修改</button>
            <button type="button" data-dismiss="modal" class="btn btn-outline dark"><i class="fa fa-times-circle"></i>&nbsp;&nbsp;取消</button>
        </div>
    </div>

    <div id="stack4" class="modal fade" tabindex="-1" data-focus-on="input:first">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <h4 class="modal-title"><i class="icon-pencil"></i>&nbsp;&nbsp;修改信息</h4>
        </div>
        <div class="modal-body">
            <div class="form-group">
                <div class="input-group select2-bootstrap-prepend">
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="button" data-select2-open="single-prepend-text">
                            <span class="glyphicon glyphicon-home green"></span>
                        </button>
                    </span>
                    <select id="plunits_1"  class="form-control select2">
                        <option></option>
                        <option value="A">A</option>
                        <option value="B">B</option>
                        <option value="C">C</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <input class="form-control" readonly id="sc_code" type="hidden" data-tabindex="1"> </div>
            <div class="form-group">
                <input class="form-control" id="sc_name" type="text" data-tabindex="2"> </div>
        </div>
        <div class="modal-footer">
            <button type="button" id="btn_alter_sce" class="btn green"><i class="fa fa-pencil"></i>&nbsp;&nbsp;确认修改</button>
            <button type="button" data-dismiss="modal" class="btn btn-outline dark"><i class="fa fa-times-circle"></i>&nbsp;&nbsp;取消</button>
        </div>
    </div>
</div>

<footer>

<!-- BEGIN CORE PLUGINS -->
    <script src="../assets/global/plugins/jquery.min.js" type="text/javascript"></script>
    <script src="../assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="../assets/global/plugins/js.cookie.min.js" type="text/javascript"></script>
    <script src="../assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
    <script src="../assets/global/plugins/jquery.blockui.min.js" type="text/javascript"></script>
    <script src="../assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js" type="text/javascript"></script>
    <!-- END CORE PLUGINS -->



    <!-- BEGIN PAGE LEVEL PLUGINS -->
    <script src="../assets/global/plugins/fancybox/source/jquery.fancybox.pack.js" type="text/javascript"></script>
    <script src="../assets/global/plugins/bootstrap-wysihtml5/wysihtml5-0.3.0.js" type="text/javascript"></script>
    <script src="../assets/global/plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.js" type="text/javascript"></script>
    <script src="../assets/global/plugins/jquery-file-upload/js/vendor/jquery.ui.widget.js" type="text/javascript"></script>
    <script src="../assets/global/plugins/jquery-file-upload/js/vendor/tmpl.min.js" type="text/javascript"></script>
    <script src="../assets/global/plugins/jquery-file-upload/js/vendor/load-image.min.js" type="text/javascript"></script>
    <script src="../assets/global/plugins/jquery-file-upload/js/vendor/canvas-to-blob.min.js" type="text/javascript"></script>
    <script src="../assets/global/plugins/jquery-file-upload/blueimp-gallery/jquery.blueimp-gallery.min.js" type="text/javascript"></script>
    <script src="../assets/global/plugins/jquery-file-upload/js/jquery.iframe-transport.js" type="text/javascript"></script>
    <script src="../assets/global/plugins/jquery-file-upload/js/jquery.fileupload.js" type="text/javascript"></script>
    <script src="../assets/global/plugins/jquery-file-upload/js/jquery.fileupload-process.js" type="text/javascript"></script>
    <script src="../assets/global/plugins/jquery-file-upload/js/jquery.fileupload-image.js" type="text/javascript"></script>
    <script src="../assets/global/plugins/jquery-file-upload/js/jquery.fileupload-audio.js" type="text/javascript"></script>
    <script src="../assets/global/plugins/jquery-file-upload/js/jquery.fileupload-video.js" type="text/javascript"></script>
    <script src="../assets/global/plugins/jquery-file-upload/js/jquery.fileupload-validate.js" type="text/javascript"></script>
    <script src="../assets/global/plugins/jquery-file-upload/js/jquery.fileupload-ui.js" type="text/javascript"></script>
    <!-- END PAGE LEVEL PLUGINS -->
    <!-- BEGIN THEME GLOBAL SCRIPTS -->
    <script src="../assets/global/scripts/app.min.js" type="text/javascript"></script>
    <script src="../assets/global/plugins/bootstrap-sweetalert/sweetalert.min.js" type="text/javascript"></script>
    <!-- END THEME GLOBAL SCRIPTS -->

<!--<script src="../assets/pages/scripts/table-datatables-buttons.min.js" type="text/javascript"></script>


 BEGIN THEME LAYOUT SCRIPTS -->
 <script src="../js/index.js" type="text/javascript"/>

 <script>
        jQuery(document).ready(function() {
// initiate layout and plugins
            Metronic.init(); // init metronic core components 重要且必需,初始化metronic核心的东东
            Layout.init(); // init current layout  重要且必需,初始化一些布局
            INDEX.init();



        });

    </script>

    <script src="../assets/layouts/layout3/scripts/layout.min.js" type="text/javascript"></script>

    <script src="../assets/global/scripts/datatable.js" type="text/javascript"></script>
    <script src="../assets/global/plugins/datatables/datatables.js" type="text/javascript"></script>
    <script src="../assets/global/plugins/datatables/plugins/bootstrap/datatables.bootstrap.js" type="text/javascript"></script>
    <script src="../assets/global/plugins/bootstrap-datepicker/js/bootstrap-datepicker.min.js" type="text/javascript"></script>


<script src="../assets/pages/scripts/ui-sweetalert.js" type="text/javascript"></script>

<script src="../assets/global/plugins/jstree/dist/jstree.min.js" type="text/javascript"></script>
<script src="../assets/pages/scripts/ui-tree.js" type="text/javascript"></script>

<script src="../assets/global/plugins/bootstrap-select/js/bootstrap-select.min.js" type="text/javascript"></script>

<script src="../assets/pages/scripts/components-bootstrap-select.min.js" type="text/javascript"></script>

<script src="../assets/global/plugins/bootstrap-modal/js/bootstrap-modalmanager.js" type="text/javascript"></script>
<script src="../assets/global/plugins/bootstrap-modal/js/bootstrap-modal.js" type="text/javascript"></script>
<script src="../assets/pages/scripts/ui-extended-modals.js" type="text/javascript"></script>
<%--    <script src="../assets/pages/scripts/table-datatables-editable.min.js" type="text/javascript"></script>--%>
<script src="../assets/global/plugins/bootstrap-wysihtml5/wysihtml5-0.3.0.js" type="text/javascript"></script>
<script src="../assets/global/plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.js" type="text/javascript"></script>
<script src="../assets/global/plugins/bootstrap-markdown/lib/markdown.js" type="text/javascript"></script>
<script src="./../assets/global/plugins/bootstrap-markdown/js/bootstrap-markdown.js" type="text/javascript"></script>
<script src="../assets/global/plugins/bootstrap-summernote/summernote.min.js" type="text/javascript"></script>
<%--<script src="../assets/pages/scripts/components-editors.js" type="text/javascript"></script>--%>
    <script src="../js/editor.js" type="text/javascript"></script>
<script src="../js/wokertable.js" type="text/javascript"></script>
<script src="../js/policetable.js" type="text/javascript"></script>
<script src="../assets/global/plugins/select2/js/select2.full.min.js" type="text/javascript"></script>
<script src="../assets/pages/scripts/components-select2.min.js" type="text/javascript"></script>
<script src="../assets/layouts/layout3/scripts/demo.min.js" type="text/javascript"></script>
<script src="../assets/global/plugins/bootstrap-tabdrop/js/bootstrap-tabdrop.js" type="text/javascript"></script>


</footer>

</body>

</html>