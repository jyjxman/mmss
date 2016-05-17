<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>
<script type="text/javascript">
    $(function() {
      

        $('#userEditForm').form({
            url : '${path }/car/edit',
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
                    $.messager.alert('错误', result.msg, 'error');
                }
            }
        });
        
        $("#status").val('${car.status}');
        $("#state").val('${car.state}');
    });
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'center',border:false" title="" style="overflow: hidden;padding: 3px;">
        <form id="userEditForm" method="post">
            <table class="grid">
                <tr>
                    <td>车辆名称</td>
                    <td><input name="id" type="hidden"  value="${car.id}"><input name="name" type="text" placeholder="请输入车辆名称" class="easyui-validatebox" data-options="required:true" value="${car.name}"></td>
                    <td>车牌号</td>
                    <td><input name="carnum" type="text" placeholder="请输入车牌号" class="easyui-validatebox" data-options="required:true" value="${car.carnum}"></td>
                </tr>
                <tr>
                    <td>车辆类型</td>
                    <td><input name="type" type="text" placeholder="请输入车辆类型" class="easyui-validatebox" data-options="required:true" value="${car.type}"></td>
                   <td>规格</td>
                    <td><input type="text" name="specification" placeholder="请输入车辆规格"  class="easyui-textbox" value="${car.specification }"/></td>
                </tr>
               
               <tr>
                <td>载重</td>
                 <td><input type="text" name="weight" placeholder="请输入车辆载重"  class="easyui-numberbox" value="${car.weight }"/></td>
                <td>单位</td>
                 <td><input type="text" name="unit" placeholder="请输入单位"  class="easyui-textbox" value="${car.unit }"/></td>
                </tr>
                <tr>
                    <td>车辆状态</td>
                    <td>
                        <select id="status" name="status" class="easyui-combobox" data-options="width:140,height:29,editable:false,panelHeight:'auto'">
                                <option value="0">闲</option>
                                <option value="1">忙</option>
                        </select>
                    </td>
                    <td>使用情况</td>
                    <td>
                        <select id="state" name="state" class="easyui-combobox" data-options="width:140,height:29,editable:false,panelHeight:'auto'">
                                <option value="0">停用</option>
                                <option value="1">使用中</option>
                        </select>
                    </td>
                </tr> 
                <tr>
                <td>描述</td>
                <td> <textarea name="remark" style="height:60px;">${car.remark}</textarea></td>
                </tr>
            </table>
        </form>
    </div>
</div>