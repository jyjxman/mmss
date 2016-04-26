<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>
<script type="text/javascript">
    $(function() {

        $('#userAddForm').form({
            url : '${path }/carrepair/add',
            onSubmit : function() {
                progressLoad();
                var isValid = $(this).form('validate');
                if (!isValid) {
                    progressClose();
                }
                return isValid;
            },
            success : function(result) {
                progressClose();
                result = $.parseJSON(result);
                if (result.success) {
                   $.modalDialog.openner_dataGrid.datagrid('reload');//之所以能在这里调用到parent.$.modalDialog.openner_dataGrid这个对象，是因为user.jsp页面预定义好了
                   $.modalDialog.handler.dialog('close');
                } else {
                    $.messager.alert('提示', result.msg, 'warning');
                }
            }
        });
        
    });
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'center',border:false" title="" style="overflow: hidden;padding: 3px;">
        <form id="userAddForm" method="post">
             <table class="grid">
               <tr>
                    <td>车辆编号</td>
                    <td><input name="carid" type="text" class="easyui-validatebox" data-options="required:true" value="" placeholder="请输入车辆编号" ></td>
                     <td>修理地址</td>
                    <td><input name="address" type="text" placeholder="请输入修理地址" class="easyui-validatebox" data-options="required:true" value=""></td>
               </tr>
                <tr>
                    <td>所需金额</td>
                    <td><input name="price" type="text" placeholder="请输入所需金额" class="easyui-validatebox" data-options="required:true" value=""></td>
                    <td>单位</td>
                    <td><input name="unit" type="text" placeholder="请输入单位" class="easyui-validatebox" data-options="required:true" value=""></td>
                </tr>
                <tr>
                <td>修理时间</td>
               <td> <input name="time" placeholder="点击选择时间" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})" readonly="readonly" /></td>
                <td>描述</td>
                <td> <textarea name="reason" style="height:60px;"></textarea></td>
                </tr>
            </table>
        </form>
    </div>
</div>