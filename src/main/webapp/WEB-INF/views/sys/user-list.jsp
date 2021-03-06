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
    /*TODO:here pages css*/

    </style>
</head>
<!-- END HEAD -->

<!-- BEGIN BODY -->
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
                                <a class="btn btn-primary navbar-btn" href="#" onclick="add();" id="addLink">
                                    <i class="ti-plus"></i> 添加文章</a>
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

    <div class="cd-panel-container">
        <div class="cd-panel-content shadow">
            <div class="form-group">
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

    function add() {
        $("#add").modal("show");
    }

    function detail(regCode){
        $("#detail-data").load("${ctx}/sys/user/"+regCode);
        $("#detail-modal").modal("show");
    }

    function delete1(id){
        if (! Modal.confirm("确定删除吗？")) return;
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