package project;

import com.alibaba.fastjson.JSONObject;
import project.vtree.*;
import java.util.ArrayList;
import java.util.List;

public class OpenChain {


    List<OpenChain> openChains = new ArrayList<>();

    public void initData() {
        TotalVTree totalVTree = JSONObject.parseObject(Constance.jsonData, TotalVTree.class);
        List<CommodityVTree> commodityVTreeList = totalVTree.getCommodityVTreeList();
        DataFactory.getInstance().commodityVTreeList.addAll(commodityVTreeList);
        for (CommodityVTree commodityVTree : commodityVTreeList) {
            List<ProductVTree> productVTrees = commodityVTree.getProductVTrees();
            DataFactory.getInstance().productVTrees.addAll(productVTrees);
        }
    }

    /**
     * 开通链
     *
     * @return
     */
    public String openChain(String id) {
        CommodityVTree commodityVTree = DataFactory.getInstance().getCommodityBeanById(id);
        return null;
    }

}
