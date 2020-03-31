package com.neuedu.hospitalbackend.controller;

import com.neuedu.hospitalbackend.model.vo.CollectionTemplateParam;
import com.neuedu.hospitalbackend.model.vo.DiagnoseTemplateParam;
import com.neuedu.hospitalbackend.model.vo.RecipeTemplateParam;
import com.neuedu.hospitalbackend.service.serviceinterface.doctorstationservice.DiagnoseTemplateService;
import com.neuedu.hospitalbackend.service.serviceinterface.doctorstationservice.ProjectCollectionTemplateService;
import com.neuedu.hospitalbackend.service.serviceinterface.doctorstationservice.RecipeTemplateManagementService;
import com.neuedu.hospitalbackend.util.CommonResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("/template")
@CrossOrigin
public class TemplateManagementController {


    @Resource
    private DiagnoseTemplateService diagnoseTemplateService;
    @Resource
    private RecipeTemplateManagementService recipeTemplateManagementService;
    @Resource
    private ProjectCollectionTemplateService projectCollectionTemplateService;


    @ApiOperation("创建常用诊断")
    @RequestMapping(value = "/diagnosetemplate/preservation", method = RequestMethod.POST)
    public CommonResult saveDiagnoseTemplate(@RequestBody DiagnoseTemplateParam diagnoseTemplateParam)
    {
        return diagnoseTemplateService.saveDiagnoseTemplate(diagnoseTemplateParam);
    }

    @ApiOperation("修改常用诊断")
    @RequestMapping(value = "/diagnosetemplate/modification", method = RequestMethod.PUT)
    public CommonResult modifyDiagnoseTemplate(@RequestBody DiagnoseTemplateParam diagnoseTemplateParam)
    {
        return diagnoseTemplateService.modifyDiagnoseTemplate(diagnoseTemplateParam);
    }

    @ApiOperation("查询常用诊断")
    @RequestMapping(value = "/diagnosetemplate/list/{roleId}", method = RequestMethod.GET)
    public CommonResult listMyDiagnoseTemplate(@PathVariable Integer roleId)
    {
        return diagnoseTemplateService.listMyDiagnoseTemplate(roleId);
    }

    //TODO 删除一个list
    @ApiOperation("删除常用诊断")
    @RequestMapping(value = "/diagnosetemplate/deletion/{roleId}/{templateId}", method = RequestMethod.DELETE)
    public CommonResult deleteMyDiagnoseTemplate(@PathVariable(value = "roleId") Integer roleId,
                                                 @PathVariable(value = "templateId") String diagnoseTemplateName)
    {
        return diagnoseTemplateService.deleteMyDiagnoseTemplate(roleId, diagnoseTemplateName);
    }



    @ApiOperation("创建处方模板")
    @RequestMapping(value = "/recipetemplate/preservation", method = RequestMethod.POST)
    public CommonResult saveRecipeTemplate(@RequestBody RecipeTemplateParam recipeTemplateParam)
    {
        return recipeTemplateManagementService.insertRecipeTemplate(recipeTemplateParam);
    }

    @ApiOperation("删除处方模板")
    @RequestMapping(value = "/recipetemplate/deletion/{roleId}/{recipeName}", method = RequestMethod.DELETE)
    public CommonResult deleteRecipeTemplate(@PathVariable(value = "roleId") Integer roleId,
                                             @PathVariable(value = "recipeName") String recipeName)
    {
        return recipeTemplateManagementService.deleteRecipeTemplate(roleId, recipeName);
    }

    @ApiOperation("查询处方模板")
    @RequestMapping(value = "/recipetemplate/list/{roleId}/{type}", method = RequestMethod.GET)
    public CommonResult listRecipeTemplate(@PathVariable(value = "roleId") Integer roleId, @PathVariable(value = "type") Integer type)
    {
        return recipeTemplateManagementService.listRecipeTemplate(roleId, type);
    }

    @ApiOperation("修改处方模板")
    @RequestMapping(value = "/recipetemplate/modification", method = RequestMethod.PUT)
    public CommonResult modifyRecipeTemplate(@RequestBody RecipeTemplateParam recipeTemplateParam)
    {
        return recipeTemplateManagementService.modifyRecipeTemplate(recipeTemplateParam);
    }


    @ApiOperation("创建检查检验处置项目模板")
    @RequestMapping(value = "/collectiontemplate/preservation", method = RequestMethod.POST)
    public CommonResult saveCollectionTemplate(@RequestBody CollectionTemplateParam collectionTemplateParam)
    {
        return projectCollectionTemplateService.insertCollectionTemplate(collectionTemplateParam);
    }

    @ApiOperation("查询检查检验处置项目模板")
    @RequestMapping(value = "/collectiontemplate/list/{roleId}/{type}", method = RequestMethod.GET)
    public CommonResult listCollectionTemplate(@PathVariable(value = "roleId") Integer roleId, @PathVariable(value = "type") Integer type)
    {
        return projectCollectionTemplateService.listCollectionTemplate(roleId, type);
    }

    @ApiOperation("删除检查检验处置项目模板")
    @RequestMapping(value = "/collectiontemplate/deletion", method = RequestMethod.DELETE)
    public CommonResult listCollectionTemplate(@RequestBody CollectionTemplateParam collectionTemplateParam)
    {
        return projectCollectionTemplateService.deleteCollectionTemplate(collectionTemplateParam);
    }

    @ApiOperation("修改检查检验处置项目模板")
    @RequestMapping(value = "/collectiontemplate/modification", method = RequestMethod.PUT)
    public CommonResult modifyCollectionTemplate(@RequestBody CollectionTemplateParam collectionTemplateParam)
    {
        return projectCollectionTemplateService.modifyCollectionTemplate(collectionTemplateParam);
    }

}
