<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/inc/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>Test</title>
    <link rel="stylesheet" href="${ctx }/frame/static/css/style.css">
    <link rel="stylesheet" href="${ctx }/frame/layui/css/layui.css">
    <script src="${ctx }/frame/layui/layui.js"></script>

</head>
<body class="body">

<fieldset class="layui-elem-field layui-field-title">
    <legend>
        <span class="layui-breadcrumb">
            <a href="javascript:;">user </a>
            <a><cite>用户管理</cite></a>
        </span>
    </legend>
</fieldset>

<div class="my-btn-box">
    <span class="fl">
        <a class="layui-btn layui-btn-danger radius btn-delect" id="btn-delete-all">批量删除</a>
        <a class="layui-btn btn-add btn-default" id="btn-add-article">添加</a>
    </span>
    <form id="searchForm">
    <span class="fr">
        <span class="layui-form-label">搜索条件：</span>
        <div class="layui-input-inline">
            <input type="text" id="projectNo" name="projectNo" value="" autocomplete="off" placeholder="请输入项目编号" class="layui-input">
        </div>
        <button class="layui-btn mgl-20 searchForm">查询</button>
        <button type="reset" class="layui-btn layui-btn-warm ">清空</button>
    </span>
    </form>
</div>

<table id="dateTable" class="layui-table">
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

<!-- jQuery -->
<script type="text/javascript" charset="utf8" src="${ctx }/frame/static/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${ctx }/frame/static/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${ctx }/frame/static/js/table-tool.js"></script>
<script type="text/javascript">


    layui.use(['element','layer'], function(){
        var $ = layui.jquery,element = layui.element,layer = layui.layer;
        //封装请求参数
        var param ={};

        //初始化表格
        var table = $("#dateTable").dataTable({
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
                var loading = layer.load(0, {shade: false}); //0代表加载的风格，支持0-2

                //封装请求参数
                param.limit = data.length;//页面显示记录条数，在页面显示每页显示多少项的时候
                param.start = data.start;//开始的记录序号
                param.page = (data.start / data.length)+1;//当前页码

                param.sort={};
                var sort={};
                sort.fields='id';
                sort.orders='asc';
                param.sort={};
                param.sort=sort;
//
//                //
//                //param.projectNo='ww';
//                param.fields='ww';

                util.fillFormData("#searchForm", param);
                var oForm =$("#searchForm").serialize();

                //alert("test"+JSON.stringify(oForm));
                //ajax请求数据
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
                        layer.close(loading);
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
                { "data": "createTime"},
                { "data": "id","mRender":function(data,type,full){
                    var html="";
                    html+='<button class="layui-btn layui-btn-small" onclick="viewDetails(\''+data+'\');">查看缴费</button>';
                    html+='<button class="layui-btn layui-btn-small layui-btn-danger" data-id="'+data+'" >删除</button>';
                    return html;
                }
                }
            ]
        }).api();
        //此处需调用api()方法,否则返回的是JQuery对象而不是DataTables的API对象


        // 例:获取ids
        $(document).on('click','#btn-delete-all', function(){
            // getIds(table对象,获取input为id的属性)
            var list = getIds($('#dateTable'),'data-id');
            if(list == null || list == ''){
                layer.msg('未选择');
            }else{
                layer.msg(list);
            }
        });


        // 业务操作代码
        //查询按钮事件
        $('.searchForm').on('click',function(){
            table.draw();//刷新
            return false;
        });

    });

    //查看详情
    function viewDetails(id){
        layer.open({
            type: 2
            ,title: '保证金信息'
            ,content: '${ctx}/pay/pay?projectId='+id
            //,shadeClose: true//开启关闭按钮
            ,maxmin: true //开启最大化最小化按钮
            ,moveType: 1 //拖拽模式，0或者1
            ,area: ['900px', '500px']
            ,shade: 0.8//遮罩层(透明度)
            ,id: id //设定一个id，防止重复弹出
            ,cancel: function(){
                //右上角关闭回调
                layer.msg('右上角关闭回调');
                //return false 开启该代码可禁止点击该按钮关闭
            }
        });
    }

    //打开添加保证金信息页面
    function openPayInput(projectId){
        layer.open({
            type: 2
            ,title: '添加保证金信息'
            ,content: '${ctx}/pay/input?projectId='+projectId
            //,shadeClose: true//开启关闭按钮
            ,maxmin: true //开启最大化最小化按钮
            ,moveType: 1 //拖拽模式，0或者1
            ,area: ['700px', '500px']
            ,shade: 0.8//遮罩层(透明度)
            ,id: '${project.id}' //设定一个id，防止重复弹出
            //,btn: ['提交']
            //,yes: function(index, layero){
            //按钮【按钮一】的回调
            //}
            ,cancel: function(){
                //右上角关闭回调
                layer.msg('右上角关闭回调');
                //return false 开启该代码可禁止点击该按钮关闭
            }
        });
    }

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
</body>
</html>