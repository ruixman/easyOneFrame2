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

<div class="page-container">
    <!-- BEGIN SIDEBAR -->
    <div class="page-sidebar-wrapper">
        <!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->
        <!-- DOC: Change data-auto-speed="200" to adjust the sub menu slide up/down speed -->
        <div class="page-sidebar navbar-collapse collapse">
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
                        <div class="portlet-title">
                            <div class="caption">
                                <i class="fa fa-list"></i>查询a
                                <label>
                                    姓名：
                                    <input id="extra1" type="text"  class="form-control input-inline">
                                    <a class="btn btn-icon-only " href="javascript:;">
                                        <i id="searchBtn" class="fa fa-search" ></i>
                                    </a>
                                </label>


                            </div>
                            <div class="tools">
                            </div>
                        </div>
                        <div class="portlet-body">
                            <div class="dataTables_wrapper">
                                <div class="row">
                                        <div class="col-md-12 col-sm-12">

                                        </div>
                                </div>
                            </div>

                            <table class="table table-striped table-bordered table-hover table-advance" id="sample_1">
                                <thead>
                                <tr>
                                    <th><input type="checkbox" class="my-checkbox" /></th>
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


            <div id="myTree"></div>


        </div>
    </div>

    <!-- END CONTENT -->
</div>
<!-- END CONTAINER -->

<!-- BEGIN FOOTER -->
<%@include file="../common/footer.jsp"%>
<!-- END FOOTER -->

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
<!-- END PAGE LEVEL PLUGINS -->
<!-- END JAVASCRIPTS -->

<script type="text/javascript">
    var table;
    var param ={};
    jQuery(document).ready(function() {
        $(".page-sidebar").load("${ctx}/sidebar.jsp");
        Metronic.init(); // init metronic core components
        Layout.init(); // init current layout
        QuickSidebar.init(); // init quick sidebar
        Demo.init(); // init demo features

        //初始化表格
        table = $("#sample_1").dataTable({
            dom: '<"top">rt<"bottom"flp><"clear">',//每页显示多少条选项 放置左下角
            language: {                           // 国际化
                "url":'${ctx}/frame/i18n/Chinese.json'
            },  //提示信息
            autoWidth: false,  //禁用自动调整列宽
            stripeClasses: ["odd", "even"],  //为奇偶行加上样式，兼容不支持CSS伪类的场合
            processing: false,  //隐藏加载提示,自行处理
            serverSide: true,  //启用服务器端分页
            bDestroy: true,
            SortCellsTop: true,
            searching: false,  //禁用原生搜索
            orderMulti: false,  //启用多列排序
            order: [],  //取消默认排序查询,否则复选框一列会出现小箭头
            renderer: "bootstrap",  //渲染样式：Bootstrap和jquery-ui
            pagingType: "full_numbers",  //分页样式：simple,simple_numbers,full,full_numbers
            info: true,
            createdRow: function( row, data, dataIndex ) {
                $(row).children('td').attr('style', 'text-align: center;')
                //让第一列和第二列居中显示：
                //$(row).children('td').eq(0).attr('style', 'text-align: center;')
                //$(row).children('td').eq(1).attr('style', 'text-align: center;')
            },
            columnDefs: [{
                "targets": [0,4],  //列的样式名
                "orderable": false    //包含上样式名‘nosort’的禁止排序
            }],
            ajax: function (data, callback, settings) {
                //显示加载动画
                //var loading = layer.load(0, {shade: false}); //0代表加载的风格，支持0-2
                $.blockUI({ message: '<h1>正在载入数据...</h1>' });
                param =userManage.getQueryCondition(data);
                $.ajax({
                    type: "POST",
                    url: "${ctx}/sys/user/list.json",  //封装表单数据
                    cache: false,  //禁用缓存
                    //data: param,//传入组装的参数
                    data: JSON.stringify(param),//将对象序列化成JSON字符串
                    dataType:"json",
                    contentType : 'application/json;charset=utf-8', //设置请求头信息
                    success: function (result) {
                        //alert(JSON.stringify(result.data));
                        //关闭加载层
                        $.unblockUI();
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
                    html+='<input type="checkbox" class="my-checkbox" data-id="'+data+'" />';
                    return html;
                }
                },
                { "data": "id"},
                { "data": "name"},
                { "data": "createTime",
                    "mRender":function (data,type,row,meta) {
                        return $.myTime.UnixToDate(data/1000);
                    }
                },
                { "data": "id","mRender":function(data,type,full){
                    var html="";
                    html+='<a class="btn green" href="#" onclick=detail("'+data+'")>查看</a>';
                    html+='<a class="btn btn-danger" href="#" onclick=delete1("'+data+'")>删除</a>';
                    return html;
                    }
                }
            ]
        }).api();

        //查询按钮事件
        $("#searchBtn").click(function(){
            $.blockUI({ message: '<h1>正在载入数据...</h1>' });
            table.ajax.reload();
            $.unblockUI();
        });


        $('#myTree').jstree({
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
            searchMap["EQ_name"]=[$("#extra1").val()];

            param.limit = data.length;//页面显示记录条数，在页面显示每页显示多少项的时候
            param.start = data.start;//开始的记录序号
            param.page = (data.start / data.length);//当前页码，jpa是基于0.

            param.searchMap= searchMap;

            param.draw = data.draw;
            return param;
        },
        editItemInit : function(item) {
            //编辑方法
            alert("编辑"+item.id+"  "+item.name);
        },
        deleteItem : function(item) {
            //删除
            alert("删除"+item.id+"  "+item.name);
        },
        showItemDetail: function(item){
            //点击行
            alert("点击"+item.id+"  "+item.name);
        }
    };

    (function($) {
        $.extend({
            myTime: {
                /**
                 * 当前时间戳
                 * @return <int>    unix时间戳(秒)
                 */
                CurTime: function(){
                    return Date.parse(new Date())/1000;
                },
                /**
                 * 日期 转换为 Unix时间戳
                 * @param <string> 2014-01-01 20:20:20 日期格式
                 * @return <int>    unix时间戳(秒)
                 */
                DateToUnix: function(string) {
                    var f = string.split(' ', 2);
                    var d = (f[0] ? f[0] : '').split('-', 3);
                    var t = (f[1] ? f[1] : '').split(':', 3);
                    return (new Date(
                        parseInt(d[0], 10) || null,
                        (parseInt(d[1], 10) || 1) - 1,
                        parseInt(d[2], 10) || null,
                        parseInt(t[0], 10) || null,
                        parseInt(t[1], 10) || null,
                        parseInt(t[2], 10) || null
                    )).getTime() / 1000;
                },
                /**
                 * 时间戳转换日期
                 * @param <int> unixTime  待时间戳(秒)
                 * @param <bool> isFull  返回完整时间(Y-m-d 或者 Y-m-d H:i:s)
                 * @param <int> timeZone  时区
                 */
                UnixToDate: function(unixTime, isFull, timeZone) {
                    if (typeof (timeZone) == 'number')
                    {
                        unixTime = parseInt(unixTime) + parseInt(timeZone) * 60 * 60;
                    }
                    var time = new Date(unixTime * 1000);
                    var ymdhis = "";
                    ymdhis += time.getUTCFullYear() + "-";
                    ymdhis += (time.getUTCMonth()+1) + "-";
                    ymdhis += time.getUTCDate();
                    if (isFull === true)
                    {
                        ymdhis += " " + time.getUTCHours() + ":";
                        ymdhis += time.getUTCMinutes() + ":";
                        ymdhis += time.getUTCSeconds();
                    }
                    return ymdhis;
                }
            }
        });
    })(jQuery);


    var util = {
        serializeObject: function(form) {
            var formEL = $(form);
            var o = {};
            var a = formEL.serializeArray();
            $.each(a, function() {
                if(o[this.name]) {
                    if(!o[this.name].push) {
                        o[this.name] = [o[this.name]];
                    }
                    o[this.name].push(this.value || '');
                } else {
                    o[this.name] = this.value || '';
                }
            });
            return o;
        },

        fillFormData: function(form, obj) {
            var formEL = $(form);
            $.each(obj, function(index, item) {
                // debugger;
                if(typeof(item)=='object'){
                    $.each(item, function(key, val) {
                        if($("#"+index+'.'+key).val()==undefined){
                            formEL.append('<input type="hidden" name="'+index+'.'+key+'" id="'+index+'.'+key+'" value="'+val+'" /> <br />');
                        }else{
                            $("#"+index+'.'+key).val(val);
                        }
                    });
                }else{
                    if(formEL.find("[name=" + index + "]").html()==undefined){
                        formEL.append('<input type="hidden" name='+index+' id="'+index+'" value="'+item+'" /> <br />');
                    }else{
                        formEL.find("[name=" + index + "]").val(item);
                    }
                }

            });
        },
        empty: function(data) {
            if(null == data || "" == data) return true;
            else return false;
        }
    };
</script>

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

</body>
<!-- END BODY -->
</html>