<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>
<script type="text/javascript">
    $(function() {

        $('#pid').combotree({
            url : '${path }/resource/tree',
            parentField : 'parentid',
            lines : true,
            panelHeight : 'auto',
            value : '${resource.parentid}'
        });
        
        $('#resourceEditForm').form({
            url : '${path }/resource/edit',
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
                    $.modalDialog.openner_treeGrid.treegrid('reload');//之所以能在这里调用到parent.$.modalDialog.openner_treeGrid这个对象，是因为resource.jsp页面预定义好了
                    
                    $.modalDialog.handler.dialog('close');
                }
            }
        });

        $("#status").val('${resource.available}');
        $("#resourcetype").val('${resource.type}');
    });
</script>
<div style="padding: 3px;">
    <form id="resourceEditForm" method="post">
        <table  class="grid">
        <tr>
        <td>编号</td>
        <td><input name="id" type="text" placeholder="请输入编号" value="${resource.id}" class="easyui-validatebox span2" data-options="required:true" ></td>
        <td>菜单路径</td>
        <td><input name="parentids" type="text" value="${resource.parentids}" placeholder="请输入菜单路径" class="easyui-validatebox span2" data-options="required:true" ></td>
        
        </tr>
            <tr>
                <td>资源名称</td>
                <td><input name="name" type="text" placeholder="请输入资源名称" value="${resource.name}" class="easyui-validatebox span2" data-options="required:true" ></td>
                 <td>资源类型</td>
                  <td><select id="resourcetype" name="type" class="easyui-combobox" data-options="width:140,height:29,editable:false,panelHeight:'auto'">
                            <option value="menu">主菜单</option>
                            <option value="submenu">子菜单</option>
                            <option value="permission">按钮</option>
                </select></td> </tr>
            <tr>
                <td>资源路径</td>
                <td><input name="url" type="text" value="${resource.url}" placeholder="请输入资源路径" class="easyui-validatebox span2" ></td>
                <td>排序</td>
                <td><input name="sortstring" value="${resource.sortstring}"  class="easyui-numberspinner" style="width: 140px; height: 29px;" required="required" data-options="editable:false"></td>
            </tr>
            <tr>
                <td>菜单图标</td>
                <td ><input  name="icon" value="${resource.icon}"/></td>
                <td>状态</td>
                <td ><select id="status" name="status" class="easyui-combobox" data-options="width:140,height:29,editable:false,panelHeight:'auto'">
                            <option value="1">正常</option>
                            <option value="0">停用</option>
                </select></td>
            </tr>
            <tr>
                <td>上级资源</td>
                <td colspan="3"><select id="pid" name="parentid" style="width: 200px; height: 29px;"></select>
                <a class="easyui-linkbutton" href="javascript:void(0)" onclick="$('#pid').combotree('clear');" >清空</a></td>
            </tr>
           
        </table>
    </form>
</div>
