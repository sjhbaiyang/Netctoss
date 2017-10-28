package com.lanou.controller;

import com.github.pagehelper.PageInfo;
import com.lanou.bean.Cost;
import com.lanou.service.CostService;
import com.lanou.utils.AjaxResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * Created by dllo on 17/10/20.
 */
@Controller
public class CostController {
    @Resource
    private CostService costService;
    @Resource
    private HttpServletRequest request;

    //跳转到主页面
    @RequestMapping(value = "/home")
    public String home() {
        return "index";
    }

    //跳转到资费管理页面
    @RequestMapping(value = "/fee/fee_list")
    public String fee_list() {
        return "fee/fee_list";
    }

    //跳转到增加界面
    @RequestMapping(value = "/fee_add")
    public String fee_add() {
        return "fee/fee_add";
    }

    //按顺序查询
    @ResponseBody
    @RequestMapping(value = "/cost_sort", method = RequestMethod.POST)
    public AjaxResult cost_asc(@Param("pageNo") Integer pageNo,
                               @Param("pageSize") Integer pageSize,
                               @Param("choose") Integer choose) {
        PageInfo<Cost> costSort = null;
        if (pageNo != null ) {
            Integer choose1 =(Integer) request.getSession().getAttribute("choose");
            costSort = costService.findCostSort(pageNo, pageSize, choose1);
        }else {
            request.getSession().setAttribute("choose", choose);
            costSort = costService.findCostSort(pageNo, pageSize, choose);
        }
        return new AjaxResult(costSort);
    }

    //验证名称是否重复
    @ResponseBody
    @RequestMapping(value = "validname")
    public boolean validname(@Param("cost") Cost cost) {
        return costService.findByName(cost);
    }


    @RequestMapping(value = "/cost_add", method = RequestMethod.POST)
    public String cost_add(@Param("cost") Cost cost) {
        if (cost.getName() == null || cost.getName().trim().equals("")) {
            return "error";
        }
        boolean byName = costService.findByName(cost);
        if (byName == false) {
            return "error";
        }
        costService.addCost(cost);
        return "fee/fee_list";
    }

    //delete_Cost
    @ResponseBody
    @RequestMapping(value = "/deleteCost", method = RequestMethod.POST)
    public boolean delete_Cost(@Param("costId") Integer costId) {
        return costService.delById(costId);
    }

    //显示当前信息
    @RequestMapping(value = "fee/fee_detail")
    public String fee_detail() {
        return "fee/fee_detail";
    }

    //查询cost信息
    @ResponseBody
    @RequestMapping(value = "/findcost", method = RequestMethod.POST)
    public Cost showcost(@Param("costId") Integer costId) {
        return costService.findById(costId);
    }

    //start_Cost
    @ResponseBody
    @RequestMapping(value = "/startCost", method = RequestMethod.POST)
    public boolean start_Cost(@Param("cost") Cost cost) {
        return costService.updateStatuById(cost);
    }

    //到修改页面
    @RequestMapping(value = "/fee/fee_modi")
    public String fee_modi() {
        return "/fee/fee_modi";
    }

    //修改cost
    @ResponseBody
    @RequestMapping(value = "/editCost", method = RequestMethod.POST)
    public boolean update_Cost(@Param("cost") Cost cost) {
        return costService.editCost(cost);
    }


    //查询资费类型
    @ResponseBody
    @RequestMapping(value = "/findAllCost", method = RequestMethod.POST)
    public List<Cost> findNameDistinct() {
        return costService.findAllCost();
    }


    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }
}
