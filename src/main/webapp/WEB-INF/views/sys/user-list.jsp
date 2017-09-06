<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
    <meta charset="utf-8"/>
    <title>会员查询</title>
    <%@include file="../common/header.jsp" %>
    <!-- BEGIN PAGE LEVEL STYLES -->
    <link rel="stylesheet" type="text/css" href="${ctx}/assets/global/plugins/select2/select2.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/assets/global/plugins/datatables/extensions/Scroller/css/dataTables.scroller.min.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/assets/global/plugins/datatables/extensions/ColReorder/css/dataTables.colReorder.min.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/assets/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.css"/>
    <!-- END PAGE LEVEL STYLES -->
    <!-- BEGIN CORE PLUGINS -->
    <%@include file="../common/import-js-core.jspf" %>
    <!-- END CORE PLUGINS -->
    <!-- BEGIN PAGE LEVEL PLUGINS -->
    <script type="text/javascript" src="${ctx}/assets/global/plugins/select2/select2.min.js"></script>
    <script type="text/javascript" src="${ctx}/assets/global/plugins/datatables/media/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="${ctx}/assets/global/plugins/datatables/extensions/TableTools/js/dataTables.tableTools.min.js"></script>
    <script type="text/javascript" src="${ctx}/assets/global/plugins/datatables/extensions/ColReorder/js/dataTables.colReorder.min.js"></script>
    <script type="text/javascript" src="${ctx}/assets/global/plugins/datatables/extensions/Scroller/js/dataTables.scroller.min.js"></script>
    <script type="text/javascript" src="${ctx}/assets/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.js"></script>
    <script type="text/javascript" src="${ctx}/assets/global/plugins/moment.min.js"></script><!-- 时间相关api-->
    <!-- END PAGE LEVEL PLUGINS -->

    <style type="text/css">
        .myodd{background-color: silver}
        .myeven{background-color: #e8e8e8}
        .selectTr{background-color: lemonchiffon }



        .cd-panel {
            position: fixed;
            top: 0;
            left: 0;
            height: 100%;
            width: 100%;
            visibility: hidden;
            -webkit-transition: visibility 0s 0.6s;
            -moz-transition: visibility 0s 0.6s;
            transition: visibility 0s 0.6s;
            z-index: 9999;
            margin-top:50px;
        }
        .cd-panel::after {
            /* overlay layer */
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background: transparent;
            cursor: pointer;
            -webkit-transition: background 0.3s 0.3s;
            -moz-transition: background 0.3s 0.3s;
            transition: background 0.3s 0.3s;
        }
        .cd-panel.is-visible {
            visibility: visible;
            -webkit-transition: visibility 0s 0s;
            -moz-transition: visibility 0s 0s;
            transition: visibility 0s 0s;
        }
        .cd-panel.is-visible::after {
            background: rgba(0, 0, 0, 0.6);
            -webkit-transition: background 0.3s 0s;
            -moz-transition: background 0.3s 0s;
            transition: background 0.3s 0s;
        }
        .cd-panel.is-visible .cd-panel-close::before {
            -webkit-animation: cd-close-1 0.6s 0.3s;
            -moz-animation: cd-close-1 0.6s 0.3s;
            animation: cd-close-1 0.6s 0.3s;
        }
        .cd-panel.is-visible .cd-panel-close::after {
            -webkit-animation: cd-close-2 0.6s 0.3s;
            -moz-animation: cd-close-2 0.6s 0.3s;
            animation: cd-close-2 0.6s 0.3s;
        }

        .cd-panel-header {
            position: fixed;
            width: 250px;
            height: 50px;
            line-height: 50px;
            background: rgba(255, 255, 255, 0.96);
            z-index: 2;
            box-shadow: 0 1px 1px rgba(0, 0, 0, 0.08);
            -webkit-transition: top 0.3s 0s;
            -moz-transition: top 0.3s 0s;
            transition: top 0.3s 0s;
            margin-top:50px;
        }
        .cd-panel-header h4 {
            font-weight: bold;
            padding-left: 5%;
            padding-top: 2%;
        }
        .from-right .cd-panel-header, .from-left .cd-panel-header {
            top: -50px;
        }
        .from-right .cd-panel-header {
            right: 0;
        }
        .from-left .cd-panel-header {
            left: 0;
        }
        .is-visible .cd-panel-header {
            top: 0;
            -webkit-transition: top 0.3s 0.3s;
            -moz-transition: top 0.3s 0.3s;
            transition: top 0.3s 0.3s;
        }

    </style>
</head>

<!-- END HEAD -->
<!-- BEGIN BODY -->
<!-- DOC: Apply "page-header-fixed-mobile" and "page-footer-fixed-mobile" class to body element to force fixed header or footer in mobile devices -->
<!-- DOC: Apply "page-sidebar-closed" class to the body and "page-sidebar-menu-closed" class to the sidebar menu element to hide the sidebar by default -->
<!-- DOC: Apply "page-sidebar-hide" class to the body to make the sidebar completely hidden on toggle -->
<!-- DOC: Apply "page-sidebar-closed-hide-logo" class to the body element to make the logo hidden on sidebar toggle -->
<!-- DOC: Apply "page-sidebar-hide" class to body element to completely hide the sidebar on sidebar toggle -->
<!-- DOC: Apply "page-sidebar-fixed" class to have fixed sidebar -->
<!-- DOC: Apply "page-footer-fixed" class to the body element to have fixed footer -->
<!-- DOC: Apply "page-sidebar-reversed" class to put the sidebar on the right side -->
<!-- DOC: Apply "page-full-width" class to the body element to have full width page without the sidebar menu -->
<body class="page-header-fixed page-quick-sidebar-over-content ">
<!-- BEGIN HEADER -->
<%@include file="../common/top.jsp" %>

<!-- END HEADER -->
<div class="clearfix"></div>
<!-- BEGIN CONTAINER -->

<section class="page-container">
    <!-- BEGIN SIDEBAR -->
    <div class="page-sidebar-wrapper">
        <!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->
        <!-- DOC: Change data-auto-speed="200" to adjust the sub menu slide up/down speed -->
        <div id="menu" class="page-sidebar navbar-collapse collapse">
        </div>
    </div>
    <!-- END SIDEBAR -->

    <!-- BEGIN CONTENT -->
    <div class="page-content-wrapper">
        <div class="page-content">
            <!-- BEGIN PAGE HEADER-->
            <div class="page-bar">
                <ul class="page-breadcrumb">
                    <li>
                        <i class="fa fa-home"></i>
                        <a href="${ctx}/index.html">首页</a>
                        <i class="fa fa-angle-right"></i>
                    </li>
                    <li>
                        用户管理
                    </li>
                </ul>
            </div>
            <!-- END PAGE HEADER-->

            <!-- BEGIN PAGE CONTENT-->
            <div class="row">
                <div class="col-md-12">

                    <!-- BEGIN EXAMPLE TABLE PORTLET-->
                    <div class="portlet">
                        <header class="header navbar bg-white shadow">
                            <div class="btn-group tool-button">
                                <a class="btn btn-primary navbar-btn" href="${base}/platform/cms/article/add" data-pjax id="addLink"><i class="ti-plus"></i> 添加文章</a>
                                <button class="btn btn-danger navbar-btn" onclick="delCheck()"><i class="ti-close"></i> 删除文章</button>
                            </div>
                            <div class="pull-right offscreen-right">
                                <button class="btn btn-primary navbar-btn" onclick="sublime.toggleFilter('.cd-panel')"><i
                                        class="fa fa-sliders"></i> 筛选
                                </button>
                            </div>
                        </header>



                        <div class="portlet-body">
                            <%--table-striped--%>
                            <table class="table table-bordered table-hover table-advance" id="sample_1">
                                <thead>
                                <tr>
                                    <th><input id="checkbox_id_all" type="checkbox" /></th>
                                    <th>用户ID</th>
                                    <th>用户名</th>
                                    <th>创建时间</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>


                                </tbody>
                            </table>

                            <!-- 测试用表格 -->
                            <table class="table table-bordered table-hover table-advance" id="sample_3">
                                <thead>
                                <tr>
                                    <th><input id="checkbox_id_all2" type="checkbox" /></th>
                                    <th>用户ID2</th>
                                    <th>用户名</th>
                                    <th>创建时间2</th>
                                    <th>操作2</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr role="row" class="myodd" >
                                    <td>
                                        <input type="checkbox" data-id="2"></td>
                                    <td>4</td>
                                    <td>12</td>
                                    <td>2017-09-04 10:52:03</td>
                                    <td><a class="btn green" href="#" onclick="detail('2')">查看</a>
                                        <a class="btn btn-danger" href="#" onclick="delete1('2')">删除</a>
                                    </td>
                                </tr>

                                <%--style="background-color: black;"--%>
                                <tr role="row"  class="myeven">
                                    <td>
                                        <input type="checkbox" data-id="2"></td>
                                    <td>4</td>
                                    <td>12</td>
                                    <td>2017-09-04 10:52:03</td>
                                    <td><a class="btn green" href="#" onclick="detail('2')">查看</a>
                                        <a class="btn btn-danger" href="#" onclick="delete1('2')">删除</a>
                                    </td>
                                </tr>

                                </tbody>
                            </table>


                        </div>
                    </div>
                    <!-- END EXAMPLE TABLE PORTLET-->
                </div>
            </div>
            <!-- END PAGE CONTENT-->
        </div>
    </div>



    <!-- END CONTENT -->
</section>
<!-- END CONTAINER -->


<div class="cd-panel from-right" aria-hidden="true">
    <header class="cd-panel-header">
        <h4>高级筛选</h4>
        <a href="javascript:;" class="cd-panel-close text-center"><i class="ti-close"></i> </a>
    </header>

    <%--<div class="portlet-title">--%>
    <%--<div class="caption">--%>
    <%--<i class="fa fa-list"></i>查询--%>
    <%--<label>--%>
    <%--姓名：--%>
    <%--<input id="extra1" type="text"  class="form-control input-inline">--%>
    <%--<a class="btn btn-icon-only " href="javascript:;">--%>
    <%--<i id="searchBtn" class="fa fa-search" ></i>--%>
    <%--</a>--%>
    <%--</label>--%>
    <%--</div>--%>
    <%--<div class="tools">--%>
    <%--</div>--%>
    <%--</div>--%>
    <div class="cd-panel-container">
        <div class="cd-panel-content shadow">
            <div class="form-group">
                <label for="title">文章标题</label>
                <input type="text" id="title" name="title" class="form-control" placeholder="文章标题" autofocus>
                <i class="fa fa-list"></i>查询
                <label>
                    姓名：
                    <input id="extra1" type="text"  class="form-control input-inline">
                    <%--<a class="btn btn-icon-only " href="javascript:;">--%>
                    <%--<i id="searchBtn" class="fa fa-search" ></i>--%>
                    <%--</a>--%>
                </label>
            </div>
            <button id="searchBtn" type="button" class="btn btn-default">查询</button>
        </div>
    </div>
</div>


<!-- BEGIN FOOTER -->
<%@include file="../common/footer.jsp"%>
<!-- END FOOTER -->

<script type="text/javascript">
    var table;
    var param ={};
    jQuery(document).ready(function() {
        $("#menu").load("${ctx}/sidebar.jsp");
        Metronic.init(); // init metronic core components
        Layout.init(); // init current layout
        QuickSidebar.init(); // init quick sidebar
        Demo.init(); // init demo features

        //初始化表格
        table = $("#sample_1").DataTable({
            dom: '<"top">rt<"bottom"flp><"clear">',//显示XX条选项 放置左下角
            //dom: '<"toolbar">frtip',
            language: {                           // 国际化
                "url":'${ctx}/frame/i18n/Chinese.json'
            },  //提示信息
            autoWidth: false,  //禁用自动调整列宽
            showRowNumber:true,
            stripeClasses: ["myodd", "myeven"],  //为奇偶行加上样式，兼容不支持CSS伪类的场合
            select:true,
            processing: false,  //隐藏加载提示,自行处理
            serverSide: true,  //启用服务器端分页
            bDestroy: true,
            SortCellsTop: true,
            searching: false,   //禁用原生搜索
            orderMulti: false,         //启用多列排序
            order: [],               //取消默认排序查询,否则复选框一列会出现小箭头
            renderer: "jquery-ui",  //渲染样式：Bootstrap和jquery-ui
            pagingType: "full_numbers",  //分页样式：simple,simple_numbers,full,full_numbers
            info: true,
//            createdRow: function( row, data, dataIndex ) {
//                $(row).children('td').attr('style', 'text-align: center;')
//                //让第一列和第二列居中显示：
//                //$(row).children('td').eq(0).attr('style', 'text-align: center;')
//                //$(row).children('td').eq(1).attr('style', 'text-align: center;')
//            },
            columnDefs: [{
                "targets": [0,4],     //列的样式名
                "orderable": false   //包含[0,4]列样式名‘nosort’的禁止排序
            }],
            ajax: function (data, callback, settings) {
                //显示加载动画
                $.blockUI({ message: '<h1>正在载入数据...</h1>' });
                param =userManage.getQueryCondition(data);
                $.ajax({
                    type: "POST",
                    url: "${ctx}/sys/user/list.json",  //封装表单数据
                    cache: false,                      //禁用缓存
                    //data: param,                     //传入组装的参数
                    data: JSON.stringify(param),      //将对象序列化成JSON字符串
                    dataType:"json",
                    contentType : 'application/json;charset=utf-8', //设置请求头信息
                    success: function (result) {
                        $.unblockUI();               //关闭加载层
                        //封装返回数据
                        var returnData = {};
                        returnData.draw = data.draw;//这里直接自行返回了draw计数器,应该由后台返回
                        returnData.recordsTotal = result.totalElements;//返回数据全部记录
                        returnData.recordsFiltered = result.totalElements;//后台不实现过滤功能，每次查询均视作全部结果
                        returnData.data = result.content;//返回的数据列表
                        //console.log(returnData);
                        //调用DataTables提供的callback方法，代表数据已封装完成并传回DataTables进行渲染
                        //此时的数据需确保正确无误，异常判断应在执行此回调前自行处理完毕
                        callback(returnData);
                    }
                });
            },
            //列表表头字段
            columns: [
                { "data": "id" ,"mRender":function(data,type,full){
                    var html="";
                    html+='<input type="checkbox" data-id="'+data+'" />';
                    return html;
                  }
                },
                { "data": "id"},
                { "data": "name"},
                { "data": "createTime",
                    "mRender":function (data,type,row,meta) {
                        return moment.unix(data/1000).format("YYYY-MM-DD HH:mm:ss");
                    }
                }
                ,
                { "data": "id","mRender":function(data,type,full){
                    var html="";
                    html+='<a class="btn green" href="#" onclick=detail("'+data+'")>查看</a>';
                    html+='<a class="btn btn-danger" href="#" onclick=delete1("'+data+'")>删除</a>';
                    return html;
                    }
                }
            ]
        });

        //查询按钮事件
        $("#searchBtn").click(function(){
            $.blockUI({ message: '<h1>正在载入数据...</h1>' });
            table.ajax.reload();
            $.unblockUI();
        });

        $('#myTree').jstree({
            plugins: ["wholerow"],
            'core' : {
                'data' : {
                    "url" : "${ctx}/sys/user/TreeTest",
                    "dataType" : "json"
                }
            }
        });

        $('#myTree').on("changed.jstree", function (e, data) {
            alert("id:" +data.selected[0]+  "\ntext:" +data.instance.get_node(data.selected[0]).text);
            //刷新整个树
            //$('#myTree').jstree().refresh();
            //手册
            //http://blog.csdn.net/qq_24472595/article/details/70053863#t9
        });

    });

    function delCheck() {
        debugger
        var chks = table.rows('.selectTr').data();
        if (chks.length > 0) {
            var ids = [];
            $.each(table.rows('.selectTr').data(), function (i, n) {
                ids.push(n.id);
            });
            var dialog = $("#dialogDelete");
            dialog.modal("show");
            dialog.find("#ok").unbind("click");
            dialog.find("#ok").bind("click", function (event) {
                var btn = $(this);
                btn.button("loading");
                $.post("${base}/platform/cms/article/delete", {ids: ids.toString()}, function (data) {
                    if (data.code == 0) {
                        datatable.ajax.reload(null,false);
                    } else {
                        Toast.error(data.msg);
                    }
                    btn.button("reset");
                    dialog.modal("hide");
                }, "json");
            });
        } else {
            Toast.warning("请先选择要删除的文章！");
        }
    }

    function getTableContent(){
        Toast.warning("这是信息","标题","");
        debugger
        var oTable = $('#sample_1').dataTable();
        var nTrs = oTable.fnGetNodes();//fnGetNodes获取表格所有行，nTrs[i]表示第i行tr对象
        for(var i = 0; i < nTrs.length; i++){
            console.log("所得的值是：：："+nTrs[0].find['']);
            console.log('[获取数据]' + oTable.fnGetData(nTrs[i]));//fnGetData获取一行的数据
        }
    }

    function detail(regCode){
        $("#detail-data").load("${ctx}/sys/user/"+regCode);
        $("#detail-modal").modal("show");
    }

    function delete1(id){
        $.blockUI();
        $.ajax({
            type: "POST",
            url: "${ctx}/sys/user/delete/"+id ,  //封装表单数据
            datatype: "html",
            success: function (result) {
                //关闭加载层
                $.unblockUI();
                table.draw();
            }
        });
    }
    // 业务操作代码
    var userManage = {
        getQueryCondition : function(data) {
            var param = {};
            //组装排序参数
//            debugger
            if (data.order&&data.order.length&&data.order[0]) {
                switch (data.order[0].column) {
                    case 1:
                        param.sort = "id";//数据库列名称
                        break;
                    case 2:
                        param.sort = "name";//数据库列名称
                        break;
                    case 3:
                        param.sort = "createTime";
                    default:
                        param.sort = "id";//数据库列名称
                        break;
                }
                //排序方式asc或者desc
                param.asc = data.order[0].dir;
            }

            /******************************************************
             * 封装条件成map<String ,String[]>
             * String : Opera_Field
             *     Opera:  条件如：EQ 等于，LIKE  CONTAIN, STARTWITH, ENDWITH, GT, LT, GTE, LTE, IN
             *     其中IN 的数组为全部，其他只取数组中的第一个
             ******************************************************/
            var searchMap = {};
            searchMap["LIKE_name"]=["%"+$("#extra1").val()+"%"];
            param.limit = data.length;//页面显示记录条数，在页面显示每页显示多少项的时候
            param.start = data.start;//开始的记录序号
            param.page = (data.start / data.length);//当前页码，jpa是基于0.
            param.searchMap= searchMap;
            param.draw = data.draw;
            return param;
        }
    };

    /**
     *全选
     /全不选    */
    $('#checkbox_id_all').click(function(){
        //debugger
        var ssf= this.checked;
        if (ssf){
            $.each($('#sample_1 tr'), function (i, n) {
                if (i==0) return;   //如果是表头则不处理
                $($(this).children()[0]).children().each(function(){
                    if (this.type=="checkbox" &&  !this.checked){
                        var aa1=$(this).parent();
                        var tr1=$(aa1).parent();
                        $(tr1).toggleClass('selectTr');
                    }
                });
            });
        }else
        {$.each($('#sample_1 tr'), function (i, n) {
                if (i==0) return;   //如果是表头则不处理
                $($(this).children()[0]).children().each(function(){
                    if (this.type=="checkbox" && this.checked){
                        var aa1=$(this).parent();
                        var tr1=$(aa1).parent();
                        $(tr1).removeClass('selectTr');
                    }
                });
            });
        }
        $(":checkbox:not(#checkbox_id_all)").attr("checked",this.checked);  //最后填充checkbox
    });

    /**
     * 多选选中和取消选中,同时选中第一个单元格单选框,并联动全选单选框
     */
    $('#sample_1 tbody').on('click', 'tr', function(event) {
        //debugger
        $($(this).children()[0]).children().each(function(i,n){
            if (this.type=="checkbox" && (!$(event.target).is(":checkbox") && $(":checkbox",this).trigger("click"))){
                if(!this.checked){
                    this.checked=true;
                }else{
                    this.checked=false;
                }
            }
        });
        $(this).toggleClass('selectTr');//放在最后处理，以便给checkbox做检测

    });

    //单击行，选中复选框
    $("#sample_1 tr").slice(1).each(function(g){
        var p=this;
        $(this).children().slice(1).click(function(){
            $($(p).children()[0]).children().each(function()
            {
                if(this.type=="checkbox"){
                    if(!this.checked){
                        this.checked=true;
                    }else{
                        this.checked=false;
                    }
                }
            });
        });
    });



    var sublime = function () {
        var linkLocation, searchOpen = false, app = $(".app"), maxHeight = 0;
        var sidebar=false,boxed=false,scroll=false;
        function redirectPage() {
            window.location = linkLocation;
        }

        function events() {
            $(".offscreen-left, .main-navigation").ontouchstart = function () {
            };
            FastClick.attach(document.body);
            $(".accordion > dd").hide();
            $(window).on("load", function () {
                $(".pageload").fadeOut("slow");
            });
            $(window).resize(function () {
                equalHeightWidgets();
                if (!$.browser.mobile && !checkBreakout()) {
                    $(".no-touch .main-navigation").slimScroll({height: 'auto'});
                    $(".no-touch .slimscroll").slimScroll({height: 'auto'});
                    initFooterFix();
                }
            });
            $(document).mouseup(function () {
                if (searchOpen === true) {
                    $('.toggle-search').click();
                }
            });
            $('.toggle-search').mouseup(function () {
                return false;
            });
            $('.header-search').mouseup(function () {
                return false;
            });
        }

        function simulateLoad(el) {
            $(el).block({
                message: '<div class="loader"></div>',
                css: {border: "none", backgroundColor: "none"},
                overlayCSS: {backgroundColor: "#fff", opacity: 0.5}
            });
        }

        function checkBreakout() {
            var state = false;
            if (app.hasClass("small-menu") || app.hasClass("fixed-scroll")) {
                state = true;
            }
            return state;
        }

        function initLinkTransition() {
            $(document).on("click", "a.transition", function (e) {
                e.preventDefault();
                e.stopPropagation();
                linkLocation = this.href;
                $("body").fadeOut(1000, "easeInOutExpo", redirectPage);
                return;
            });
        }

        function initAccordion() {
            $(".accordion > dd").first().show();
            $(".accordion > dt > a").first().addClass("active");
            $(document).on("click", ".accordion > dt > a", function (e) {
                e.preventDefault();
                e.stopPropagation();
                $(this).closest(".accordion").find("dd").slideUp(800, "easeInOutExpo");
                $(this).closest(".accordion").find("a").removeClass("active");
                if ($(this).parent().next().css("display") !== "block") {
                    $(this).parent().next().slideDown();
                    $(this).addClass("active");
                    return false;
                }
                return false;
            });
        }

        function initAnimationAPI() {
            if (!$.browser.mobile && $.fn.appear) {
                $("[data-animation]").appear();
                $("[data-animation]").on("appear", function () {
                    var elm = $(this), animation = elm.data("animation") || "fadeIn", delay = elm.data("delay") || 0;
                    if (!elm.hasClass("done")) {
                        setTimeout(function () {
                            elm.addClass("animated " + animation + " done");
                        }, delay);
                    }
                });
            } else {
                $("[data-animation]").each(function () {
                    var elm = $(this), animation = elm.data("animation") || "fadeIn";
                    if (!elm.hasClass("done")) {
                        elm.addClass("animated " + animation + " done");
                    }
                });
            }
        }

        function initAnimateNumbers() {
            if (!$.browser.mobile && $.fn.appear) {
                $(".count").appear();
                $(".count").on("appear", function () {
                    if (!$(this).hasClass("done")) {
                        var speed = $(this).data("speed") || 2000, interval = $(this).data("interval") || 100;
                        $(this).addClass("done").countTo({speed: speed, refreshInterval: interval});
                    }
                });
            } else {
                $(".count").each(function () {
                    if (!$(this).hasClass("done")) {
                        $(this).addClass("done").countTo({speed: 1000});
                    }
                });
            }
        }

        function initAnimateProgressBars() {
            if (!$.browser.mobile && $.fn.appear) {
                $(".progress-bar").appear();
                $(".progress-bar").on("appear", function () {
                    var elm = $(this), percent = elm.data("percent");
                    if (!elm.hasClass("done")) {
                        elm.addClass("done").css("width", Math.ceil(percent) + "%");
                    }
                });
            } else {
                $(".progress-bar").each(function () {
                    var elm = $(this), percent = elm.data("percent");
                    if (!elm.hasClass("done")) {
                        elm.addClass("done").css("width", Math.ceil(percent) + "%");
                    }
                });
            }
        }

        function initBrowserFix() {
            if (navigator.userAgent.search("Firefox") >= 0) {
                $(".layout > aside, .layout > section").wrapInner("<div class=\"fffix\"/>");
            }
        }

        function initDatePicker() {
            if ($.isFunction($.fn.datepicker)) {
                $(".datepicker").datepicker();
            }
        }

        function initFuelUX() {
            if ($.isFunction($.fn.wizard)) {
                $(".wizard").wizard();
            }
            if ($.isFunction($.fn.pillbox)) {
                $(".pillbox").pillbox();
            }
            if ($.isFunction($.fn.spinner)) {
                $(".spinner").spinner();
            }
        }

        function initChosen() {
            if ($.isFunction($.fn.chosen)) {
                $(".chosen").chosen();
            }
        }

        function equalHeightWidgets() {
            $('.equal-height-widgets').each(function () {
                maxHeight = 0;
                $(this).find('.widget').each(function () {
                    if ($(this).innerHeight() > maxHeight) {
                        maxHeight = $(this).innerHeight();
                    }
                });
                $(this).find('.widget').each(function () {
                    $(this).height(maxHeight);
                });
            });
        }

        function initBoxCollapse() {
            $(document).on("click", ".widget-collapsible", function (e) {
                var el = $(this).parents(".widget").children(".widget-body");
                if (el.is(':visible')) {
                    $(this).removeClass("ti-angle-down").addClass("ti-angle-up");
                    el.slideUp(200);
                } else if (!el.is(':visible')) {
                    $(this).removeClass("ti-angle-up").addClass("ti-angle-down");
                    el.slideDown(200);
                }
                e.preventDefault();
                e.stopPropagation();
            });
        }

        function initBoxRefresh() {
            $(document).on("click", ".widget-refresh", function (e) {
                var elm = $(this).parents(".widget");
                simulateLoad(elm);
                window.setTimeout(function () {
                    $(elm).unblock();
                }, 3000);
                e.preventDefault();
                e.stopPropagation();
            });
        }

        function initBoxRemove() {
            $(document).on("click", ".widget-remove", function (e) {
                $(this).parents(".widget").addClass("animated fadeOutRight").attr("id", "obsolete");
                setTimeout(function () {
                    $("#obsolete").remove();
                }, 600);
                e.preventDefault();
                e.stopPropagation();
            });
        }

        function initPlacehoderFallback() {
            $('input, textarea').placeholder();
        }

        function initHeaderSearch() {
            $(document).on("click", ".toggle-search", function () {
                if (!searchOpen) {
                    $('.header-search').addClass('open');
                    $('.search-container .search').focus();
                    searchOpen = true;
                } else {
                    $('.header-search').removeClass('open');
                    $('.search-container .search').focusout();
                    searchOpen = false;
                }
            });
        }

        function initMenuCollapse() {
            //顶部导航浮动显示,觉得体验不好注释掉
            $(document).on("mouseover", ".topnav a", function (e) {
                var links = $(this).parents('li'), parentLink = $(this).closest("li"), otherLinks = $('.topnav li').not(links), subMenu = $(this).next();
                if (!parentLink.hasClass("open")) {
                    parentLink.addClass("open");
                }
                if (otherLinks.hasClass("open")) {
                    otherLinks.removeClass("open");
                }
                $(this).children(".sub-menu").show();
                if (subMenu.is("ul") && (!subMenu.is(":visible")))
                    subMenu.slideDown();
                if ($(this).attr('href') === '#') {
                    e.preventDefault();
                }
                subMenu.find('.sub-menu').each(function(){
                    $(this).show();
                });
                if (subMenu.is("ul")) {
                    return false;
                }
                e.stopPropagation();
                return true;
            });
            $(document).on("click", ".main-navigation a", function (e) {
                var links = $(this).parents('li'), parentLink = $(this).closest("li"), otherLinks = $('.main-navigation li').not(links), subMenu = $(this).next();
                if (!subMenu.hasClass("sub-menu")) {
                    offscreen.hide();
                    return;
                }
                if (app.hasClass("small-menu") && parentLink.parent().hasClass("nav") && $(window).width() > 767) {
                    return;
                }
                otherLinks.removeClass('open');
                otherLinks.find('.sub-menu').slideUp();
                if (subMenu.is("ul") && (!subMenu.is(":visible")) && (!app.hasClass("small-sidebar"))) {
                    subMenu.slideDown();
                    parentLink.addClass("open");
                }
                else if (subMenu.is("ul") && (subMenu.is(":visible")) && (!app.hasClass("small-sidebar"))) {
                    parentLink.removeClass("open");
                    subMenu.slideUp();
                }
                if ($(this).hasClass('active') === false) {
                    $(this).parents("ul.dropdown-menu").find('a').removeClass('active');
                    $(this).addClass('active');
                }
                if ($(this).attr('href') === '#') {
                    e.preventDefault();
                }
                if (subMenu.is("ul")) {
                    return false;
                }
                e.stopPropagation();
                return true;
            });
            $(".main-navigation > .nav > li.open").each(function () {
                $(".sub-menu").hide();
                $(this).children(".sub-menu").show();
            });
            $(".no-touch .main-navigation, .no-touch .slimscroll").each(function () {
                if (checkBreakout() || app.hasClass("fixed-scroll") || $.browser.mobile) {
                    return;
                }
                var data = $(this).data();
                $(this).slimScroll(data);
            });
            $(document).on("click", ".header .dropdown-menu a", function (e) {
                var links = $(this).parents('li'), parentLink = $(this).closest("li"), otherLinks = $('.header .dropdown  li').not(links),
                        subMenu = $(this).next();
                otherLinks.removeClass('open');
                otherLinks.find('.sub-menu').slideUp();
                if (subMenu.is("ul") && (!subMenu.is(":visible")) ) {
                    subMenu.slideDown();
                    parentLink.addClass("open");
                }
                else if (subMenu.is("ul") && (subMenu.is(":visible"))) {
                    parentLink.removeClass("open");
                    subMenu.slideUp();
                }
                if ($(this).hasClass('active') === false) {
                    $(this).parents("ul.dropdown-menu").find('a').removeClass('active');
                    $(this).addClass('active');
                }
                if ($(this).attr('href') === '#'||$(this).attr('href') === 'javascript:;') {
                    e.preventDefault();
                }else{
                    $(".dropdown").removeClass('open');
                }
                e.stopPropagation();
                return true;
            });
            $(".header > .nav > .dropdown-menu > li.open").each(function () {
                $(".sub-menu").hide();
                $(this).children(".sub-menu").show();
            });
        }

        function initToggleActiveState() {
            $(document).on("click", ".toggle-active", function (e) {
                $(this).toggleClass("active");
                e.preventDefault();
                e.stopPropagation();
            });
        }

        function initToggleSidebar() {
            $(document).on("click", ".toggle-sidebar", function (e) {
                e.preventDefault();
                e.stopPropagation();
                if (app.hasClass("small-menu")) {
                    app.removeClass("small-menu");
                    if (!$.browser.mobile && !checkBreakout() && $.fn.slimScroll) {
                        $(".no-touch .main-navigation").each(function () {
                            var data = $(this).data();
                            $(this).slimScroll(data);
                        });
                    }
                    jQuery.post(base+"/platform/login/layout", {p:"sidebar",v:false});
                } else if (!app.hasClass("small-menu")) {
                    app.addClass("small-menu");
                    if (!$.browser.mobile && $.fn.slimScroll) {
                        $(".no-touch .main-navigation").each(function () {
                            $(this).slimScroll({destroy: true}).removeAttr('style');
                        });
                    }
                    jQuery.post(base+"/platform/login/layout", {p:"sidebar",v:true});
                }
            });
        }

        function initToggleBoxed() {
            $(document).on("click", ".toggle-boxed", function (e) {
                if(app.hasClass("boxed")){
                    app.removeClass("boxed");
                    jQuery.post(base+"/platform/login/layout", {p:"boxed",v:false});
                }else{
                    app.addClass("boxed");
                    jQuery.post(base+"/platform/login/layout", {p:"boxed",v:true});
                }
                e.preventDefault();
                e.stopPropagation();
            });
        }

        function initToggleScroll() {
            $(document).on("click", ".toggle-scroll", function (e) {
                if(app.hasClass("fixed-scroll")){
                    app.removeClass("fixed-scroll");
                    jQuery.post(base+"/platform/login/layout", {p:"scroll",v:false});
                }else{
                    app.addClass("fixed-scroll");
                    jQuery.post(base+"/platform/login/layout", {p:"scroll",v:true});
                }
                e.preventDefault();
                e.stopPropagation();
            });
        }

        function initViewSwitcher() {
            $(document).on("click", ".view-options label", function (e) {
                if ($(this).data("view") === "grid") {
                    $(".switcher").addClass("view-grid").removeClass("view-list");
                } else if ($(this).data("view") === "list") {
                    $(".switcher").addClass("view-list").removeClass("view-grid");
                } else {
                    return;
                }
                e.preventDefault();
                e.stopPropagation();
            });
        }

        function initFooterFix() {
            $("footer").each(function () {
                var footerHeight = $(this).outerHeight();
                if ($(this).prev().hasClass("content-wrap")) {
                    $(this).prev().find(".wrapper").css("bottom", footerHeight);
                }
            });
        }

        function initSlider() {
            if ($.isFunction($.fn.slider)) {
                $(".sliders input").slider();
            }
        }

        function initSortableLists() {
            if ($.isFunction($.fn.sortable)) {
                $(".sortable").sortable();
                $(".handles").sortable({handle: "span"});
            }
        }

        function initIcheck() {
            if ($.isFunction($.fn.iCheck)) {
                $(".icheck").iCheck();
            }
        }

        function initTheme(){

            $(document).on("click", ".pg-toggle", function (e) {
                e.preventDefault();
                if ($(".playground").hasClass("opened")) {
                    $(".playground").removeClass("opened");
                } else {
                    $(".playground").addClass("opened");
                }
            });
            $(document).on("click", ".pg-close", function (e) {
                e.preventDefault();
                if ($(".playground").hasClass("opened")) {
                    $(".playground").removeClass("opened");
                }
            });
            $(document).on("click", ".playground .font-options a", function (e) {
                e.preventDefault();
                var value = $(this).attr("href");
                $(".font-options").find("a").removeClass("active");
                $(this).addClass("active");
                $("#font").attr("href", value)
            });
            $(document).on("click", ".playground .header-options a", function (e) {
                e.preventDefault();
                var value = $(this).attr("id");
                if (value === "header-dark") {
                    $(".header").addClass("header-dark")
                } else {
                    $(".header").removeClass("header-dark")
                }
                $(".header-options").find("a").removeClass("active");
                $(this).addClass("active")
            });
            $(document).on("click", ".playground .color-options > a", function (e) {
                e.preventDefault();
                var value = $(this).attr("href");
                $(".color-options").find("a").removeClass("active");
                $(this).addClass("active");
                $("#skin").attr("href", value)
            });
        }
        return {
            checkBreakout: checkBreakout, init: function () {
                events();
                initAccordion();
                initAnimationAPI();
                initAnimateNumbers();
                initAnimateProgressBars();
                initLinkTransition();
                initBoxRefresh();
                initBoxRemove();
                initHeaderSearch();
                initBrowserFix();
                initMenuCollapse();
                initToggleActiveState();
                initToggleSidebar();
                initToggleScroll();
                initToggleBoxed();
                initViewSwitcher();
                initFooterFix();
                equalHeightWidgets();
                initDatePicker();
                initFuelUX();
                initChosen();
                initBoxCollapse();
                initPlacehoderFallback();
                initSlider();
                initSortableLists();
                initIcheck();
                initTheme();
            },
            initIcheck : initIcheck,//初始化复选框控件
            changeLang:function(lang){
                var url = window.location.href;
                if(url.indexOf("lang=")>0){
                    url=url.replace("?lang="+GetQueryString("lang"),"").replace("&lang="+GetQueryString("lang"),"");
                    console.log(url);
                } console.log(url);
                if(url.indexOf("?")>0){
                    url+="&lang="+lang;
                }else {
                    url+="?lang="+lang;
                }
                window.location.href=url;
            },
            changeTheme:function(obj){
                jQuery.post(base+"/platform/login/theme", {loginTheme:obj});
            },
            showLoadingbar : function(obj){//显示顶部进度条
                var clz = "waiting";
                if(!obj){
                    clz += " full";
                }
                obj = obj || $("body");
                if($("#loadingbar").length<1){
                    obj.prepend("<div id=\"loadingbar\"></div>");
                    $("#loadingbar").addClass(clz).append($("<dt/><dd/>"));
                    $("#loadingbar").width((50 + Math.random() * 30) + "%");
                    var width = (50 + Math.random() * 30);
                    var interval = setInterval(function(){
                        width = width + 10;
                        if(width<100){
                            $("#loadingbar").width(width + "%");
                        }else{
                            $("#loadingbar").width("101%");
                            clearInterval(interval);
                        }
                    }, 1000);
                    $("#loadingbar").attr("interval", interval);
                }
            },
            closeLoadingbar : function(obj){//关闭顶部进度条
                obj = obj || $("body");
                obj.find("#loadingbar").width("101%").delay(200).fadeOut(400, function() {
                    var interval =  $(this).attr("interval");
                    clearInterval(interval);
                    $("#loadingbar").remove();
                });
            },
            toggleFilter : function(filter){//显示/隐藏筛选面板
                var filter = $(filter);
                filter.addClass('is-visible');

                filter.unbind("click");
                filter.bind("click", function(event){
                    if( $(event.target).is('.cd-panel') || $(event.target).is('.cd-panel-close') ) {
                        filter.removeClass('is-visible');
                        event.preventDefault();
                    }
                });
            }
        };
    }();
</script>
<!-- END JAVASCRIPTS -->

<div id="add" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header bg-primary">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                <h4 class="modal-title">
                    <i class="icon-pencil"></i>
                    <span id="lblAddTitle" style="font-weight:bold">审核会员</span>
                </h4>
            </div>
            <form class="form-horizontal form-bordered form-row-strippe" id="ffAdd" onsubmit="return checkAudit()" action="" data-toggle="validator" methpd="post" enctype="multipart/form-data">
                <div class="modal-body">
                    <div class="row">
                        <div class="col-md-12" id="divSel">
                            <div class="form-group">
                                <label class="control-label col-md-2">会员类型选择</label>
                                <div class="col-md-10">
                                    <select id="select_id" name="levelType2" type="text" class="form-control select2" placeholder="选择升级类型..." ></select>
                                </div>
                            </div>
                        </div>

                        <div class="col-md-12">
                            <div class="form-group">
                                <label class="control-label col-md-2">代码</label>
                                <div class="col-md-10">
                                    <input id="regCode" name="regCode" type="text" class="form-control" readOnly />
                                </div>
                            </div>
                        </div>
                        <div class="col-md-12">
                            <div class="form-group">
                                <label class="control-label col-md-2">名称</label>
                                <div class="col-md-10">
                                    <input id="regName" name="regName" type="text" class="form-control" readOnly />
                                </div>
                            </div>
                        </div>
                        <div class="col-md-12">
                            <div class="form-group">
                                <label class="control-label col-md-2">注册类型</label>
                                <div class="col-md-10">
                                    <input id="levelName" name="levelName" type="text" class="form-control" readOnly />
                                    <input id="levelType" name="levelType" type="hidden" class="form-control" readOnly />
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
                <div class="modal-footer bg-info">
                    <button type="submit" class="btn blue" >确定</button>
                    <button type="button" class="btn green" data-dismiss="modal">取消</button>
                </div>
            </form>
        </div>
    </div>
</div>

<div id="detail-modal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header bg-primary">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                <h4 class="modal-title">
                    <i class="icon-pencil"></i>
                    <span id="lblAddTitle1" style="font-weight:bold">详细内容</span>
                </h4>
            </div>
            <div class="modal-body">
                <div id="detail-data" class="row">

                </div>
            </div>
            <div class="modal-footer bg-info">
                <button type="button" class="btn green" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>

<div id="dialogDelete" class="modal fade bs-modal-sm" tabindex="-2" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title">删除</h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-xs-12">
                        删除后无法恢复，确定删除吗？ <br/>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取 消</button>
                <button id="ok" type="button" class="btn btn-primary" data-loading-text="正在删除...">确 定</button>
            </div>
        </div>
    </div>
</div>

</body>
<!-- END BODY -->
</html>