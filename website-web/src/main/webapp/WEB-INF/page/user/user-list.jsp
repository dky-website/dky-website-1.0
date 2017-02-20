<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> - jqGird</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <link rel="shortcut icon" href="favicon.ico">
    <style>
        #alertmod_table_list_2 {
            top: 900px !important;
        }
    </style>
    <jsp:include page="../include.jsp"></jsp:include>
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content  animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox ">
                <div class="ibox-title">
                    <h5>用户管理</h5>
                </div>
                <div class="">
                    <button type="button" class="btn btn-w-m btn-success" id="addBtn">新增</button>
                </div>
                <div class="ibox-content">
                    <hr>
                    <h4>用户列表</h4>
                    <div class="jqGrid_wrapper">
                        <table id="table_list"></table>
                        <div id="pager_list"></div>
                    </div>
                    <p>&nbsp;</p>
                </div>
            </div>
        </div>
    </div>
</div>



<div id="add-modal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header bg-info">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                <h4 class="modal-title">
                    <i class="icon-pencil"></i>
                    <span  style="font-weight:bold">用户新增</span>
                </h4>
            </div>
            <form class="form-horizontal form-bordered form-row-strippe" id="addForm" action="" data-toggle="validator">
                <div class="modal-body" id="add-data">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-group">
                                <label class="control-label col-md-2">用户名:</label>
                                <div class="col-md-10">
                                    <input name="username" type="text"  class="form-control" placeholder="用户名" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">昵称:</label>
                                <div class="col-md-10">
                                    <input name="nickname" type="text"  class="form-control" placeholder="昵称" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">电话:</label>
                                <div class="col-md-10">
                                    <input name="phone" type="text"  class="form-control" placeholder="电话" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">邮箱:</label>
                                <div class="col-md-10">
                                    <input name="email" type="text"  class="form-control" placeholder="邮箱" />
                                </div>
                            </div>
                            <div class="form-group">
                            <label class="control-label col-md-2">图片:</label>
                                <div class="col-md-10">
                                    <div class="demo l_f">
                                        <div class="logobox"><div class="resizebox"><img src="${ctx}/assets/img/upload.png" width="100px" alt="" height="100px"/></div></div>
                                        <div class="logoupload">
                                            <input type="hidden" name="fBrandLogo" id="fBrandLogo"  />
                                            <div class="btnbox"><a id="uploadBtnHolder" class="uploadbtn" href="javascript:;">上传替换</a></div>
                                            <div style="clear:both;height:0;overflow:hidden;"></div>
                                            <div class="progress-box" style="display:none;">
                                                <div class="progress-num">上传进度：<b>0%</b></div>
                                                <div class="progress-bar"><div style="width:0%;" class="bar-line"></div></div>
                                            </div>
                                        </div>

                                    </div> <div class="prompt"><p>图片大小<b>120px*60px</b>图片大小小于5MB,</p><p>支持.jpg;.gif;.png;.jpeg格式的图片</p></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-sm" data-dismiss="modal">取消</button>
                    <button type="button" id="update-btn" class="btn btn-sm btn-success">确定</button>
                </div>
            </form>
        </div>
    </div>
</div>

<!-- Page-Level Scripts -->
<script>
    $(document).ready(function () {
        $.jgrid.defaults.styleUI = 'Bootstrap';
        $("#table_list").jqGrid({
            datatype: "json",
            url: '${ctx}/user/page',
            mtype : 'POST',
            height: 500,
            autowidth: true,
            shrinkToFit: true,
            rowNum: 14,
            rowList: [10, 20, 30],
            colNames: ['id', '用户名', '昵称', '电话', '邮箱', '状态', '操作'],
            colModel: [
                {
                    name: 'id',
                    index: 'id',
                    width: 60,
                    sorttype: "int"
                },
                {
                    name: 'username',
                    index: 'username',
                    width: 90
                },
                {
                    name: 'nickname',
                    index: 'nickname',
                    width: 100
                },
                {
                    name: 'phone',
                    index: 'phone',
                    width: 80,
                    sorttype: "int"
                },
                {
                    name: 'email',
                    index: 'email',
                    width: 80
                },
                {
                    name: 'status',
                    index: 'status',
                    width: 50,
                    formatter : function(cellvalue, options, rowObject){
                        if(cellvalue == '0'){
                            return '<p><span class="label label-primary">启用</span></p>';
                        }else if(cellvalue == '1'){
                            return '<p><span class="label label-danger">禁用</span></p>';
                        }
                        return cellvalue;
                    }
                },
                {
                    name: 'id',
                    index: 'id',
                    width: 150,
                    sortable: false,
                    formatter: function(cellvalue, options, rowObject){
                        var html = '<button class="btn btn-info" type="button"><i class="fa fa-paste"></i> 编辑</button>&nbsp;&nbsp;';
                        html += '<button class="btn btn-warning " type="button"><i class="fa fa-warning"></i> <span class="bold">删除</span> </button>';
                        return html;
                    }
                }
            ],
            pager: "#pager_list",
            viewrecords: true,
            hidegrid: false,
            jsonReader :{
                root: "result",    // json中代表实际模型数据的入口
                page: "pageNum",    // json中代表当前页码的数据
                total: "pages",    // json中代表页码总数的数据
                records: "total", // json中代表数据行总数的数据
                repeatitems: false
            },
            multiselect : true,
            autowidth: true,
            sortname: 'id',
            viewrecords: true,
            sortorder: "desc"
        });



        $('#addBtn').bind('click',function(){
//            $('#add-data').html(template('add-tmpl',{}));
            $("#add-modal").modal({backdrop: 'static', keyboard: false});
        });

    });
</script>
</body>



<!-- script templcate -->
<script id="add-tmpl" type="text/html">

</script>


<script type="text/javascript">
    function updateProgress(file) {
        $('.progress-box .progress-bar > div').css('width', parseInt(file.percentUploaded) + '%');
        $('.progress-box .progress-num > b').html(SWFUpload.speed.formatPercent(file.percentUploaded));
        if(parseInt(file.percentUploaded) == 100) {
            // 如果上传完成了
            $('.progress-box').hide();
        }
    }

    function initProgress() {
       $('.progress-box').show();
        $('.progress-box .progress-bar > div').css('width', '0%');
        $('.progress-box .progress-num > b').html('0%');
    }

    function successAction(fileInfo) {
        var up_path = fileInfo.path;
        var up_width = fileInfo.width;
        var up_height = fileInfo.height;
        var _up_width,_up_height;
        if(up_width > 120) {
            _up_width = 120;
            _up_height = _up_width*up_height/up_width;
        }
       $(".logobox .resizebox").css({width: _up_width, height: _up_height});
        $(".logobox .resizebox > img").attr('src', '../'+up_path);
        $(".logobox .resizebox > img").attr('width', _up_width);
        $(".logobox .resizebox > img").attr('height', _up_height);
        $('#fBrandLogo').val(up_path);
    }

    var swfImageUpload;
    $(document).ready(function() {
        var settings = {
            flash_url : "${ctx}/assets/js/plugins/swfupload/swfupload.swf",
            flash9_url : "${ctx}/assets/js/plugins/swfupload/swfupload_fp9.swf",
            upload_url: "${ctx}/upload/file",// 接受上传的地址
            file_size_limit : "5MB",// 文件大小限制
            file_types : "*.jpg;*.gif;*.png;*.jpeg;",// 限制文件类型
            file_types_description : "图片",// 说明，自己定义
            file_upload_limit : 100,
            file_queue_limit : 0,
            custom_settings : {},
            debug: false,
            // Button settings
            button_image_url: "${ctx}/assets/js/plugins/swfupload/upload-btn.png",
            button_width: "95",
            button_height: "30 ",
            button_placeholder_id: 'uploadBtnHolder',
            button_window_mode : SWFUpload.WINDOW_MODE.TRANSPARENT,
            button_cursor : SWFUpload.CURSOR.HAND,
            button_action: SWFUpload.BUTTON_ACTION.SELECT_FILE,

            moving_average_history_size: 40,

            // The event handler functions are defined in handlers.js
            swfupload_preload_handler : preLoad,
            swfupload_load_failed_handler : loadFailed,
            file_queued_handler : fileQueued,
            file_dialog_complete_handler: fileDialogComplete,
            upload_start_handler : function (file) {
                initProgress();
                updateProgress(file);
            },
            upload_progress_handler : function(file, bytesComplete, bytesTotal) {
                updateProgress(file);
            },
            upload_success_handler : function(file, data, response) {
                // 上传成功后处理函数
                var fileInfo = eval("(" + data + ")");
                console.log(data);
                successAction(fileInfo);
            },
            upload_error_handler : function(file, errorCode, message) {
                alert('上传发生了错误！');
            },
            file_queue_error_handler : function(file, errorCode, message) {
                if(errorCode == -110) {
                    alert('您选择的文件太大了。');
                }
            }
        };
        swfImageUpload = new SWFUpload(settings);
    });
</script>



</html>
