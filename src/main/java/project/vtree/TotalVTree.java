package project.vtree;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class TotalVTree implements Serializable {

    String rootId;
    ProductVTree empty;
    ProductVTree finish;

    List<CommodityVTree> commodityVTreeList = new ArrayList<>();


    public TotalVTree create() {
        //1.首先获取需要配置的商品id作为rootId
        rootId = "R1234";

        //2.创建Empty节点
        empty = new ProductVTree();
        empty.cliqueId = rootId;
        //2-1 为empty节点生成id
        empty.id = "E1234";

        //3.创建Finish节点
        finish = new ProductVTree();
        finish.cliqueId = rootId;
        finish.id = "F1234";

        empty.childList.add(finish.id);
        finish.parentList.add(empty.id);

        addCommodity();

        List<String> childList = empty.childList;
        for (String s : childList) {
            printTree(s);
        }

        return this;
    }

    public void printTree(String child) {
        if (child == null || child.equals(finish.id)) {
            return;
        }
        ProductVTree baseBean = DataFactory.getInstance().getBaseBeanById(child);
        System.out.println("准备开通产品：" + baseBean.id);
        int parentStatus = 1;
        if (baseBean.parentList.size() >= 2) {
            for (String parent : baseBean.parentList) {
                ProductVTree parentBean = DataFactory.getInstance().getBaseBeanById(parent);
                if (parentBean.use == 0) {
                    System.out.println("父节点还没有开通完，等待....");
                    parentStatus = 0;
                    break;
                }
            }
        }

        if (parentStatus == 1) {
            //开通
            baseBean.use = 1;
            System.out.println("开通产品: " + child);
            DataFactory.getInstance().updateBaseBean(baseBean);
            if (baseBean.childList.size() >= 1) {
                for (String s : baseBean.childList) {
                    printTree(s);
                }
            }
        }
    }


    private void addCommodity() {
        //添加商品，一个商品即是一个V_Tree,添加商品其实就是在现有的V_Tree上添加子或者父V_Tree
        //第一个商品
        CommodityVTree aTree = new CommodityVTree().create("APPLE---",true);
//        List<String> childList = aTree.empty.childList;
        //把第一个商品的empty节点的父节点，改为当前的empty节点
        aTree.empty.parentList.clear();
        aTree.empty.parentList.add(empty.id);
        //把第一个商品的finish节点的子节点，改为当前的finish节点
        aTree.finish.childList.add(finish.id);
        finish.parentList.add(aTree.finish.id);
        finish.parentList.add(aTree.finish.id);
        empty.childList.add(aTree.empty.id);
        aTree.rootId = rootId;

        finish.parentList.remove(empty.id);
        empty.childList.remove(finish.id);

        //第二个商品 第二个商品与第一个商品可以并行开通
        CommodityVTree bTree = new CommodityVTree().create("BANANA---",true);
        //把第二个商品的empty节点的父节点，改为当前的empty节点
        bTree.empty.parentList.clear();
        bTree.empty.parentList.add(empty.id);
        //把第二个商品的finish节点的子节点，改为当前的finish节点
        bTree.finish.childList.add(finish.id);
        finish.parentList.add(bTree.finish.id);
        empty.childList.add(bTree.empty.id);
        bTree.rootId = rootId;

        //第三个商品，第三个商品要依赖于第一第二个商品结束后才能开通
        CommodityVTree cTree = new CommodityVTree().create("CHEERY---",false);
        aTree.finish.childList.clear();
        bTree.finish.childList.clear();
        aTree.finish.childList.add(cTree.empty.id);
        bTree.finish.childList.add(cTree.empty.id);

        cTree.empty.parentList.add(aTree.finish.id);
        cTree.empty.parentList.add(bTree.finish.id);

        finish.parentList.remove(aTree.finish.id);
        finish.parentList.remove(bTree.finish.id);
        cTree.finish.childList.clear();
        cTree.finish.childList.add(finish.id);
        finish.parentList.add(cTree.finish.id);
        cTree.rootId = rootId;

        //第四个商品，第四个商品是做为第一个商品的前置条件
        CommodityVTree dTree = new CommodityVTree().create("DURIAN---",true);
        //设置第四个商品的empty节
        dTree.empty.parentList.clear();
        dTree.empty.parentList.add(empty.id);

        empty.childList.remove(aTree.empty.id);
        empty.childList.add(dTree.empty.id);

        dTree.finish.childList.clear();
        dTree.finish.childList.add(aTree.empty.id);

        aTree.empty.parentList.clear();
        aTree.empty.parentList.add(dTree.finish.id);
        dTree.rootId = rootId;



        //第五个商品，第五个商品要依赖于第一第二个商品结束后才能开通
        CommodityVTree eTree = new CommodityVTree().create("EGGFRUIT---",true);

        aTree.finish.childList.add(eTree.empty.id);
        bTree.finish.childList.add(eTree.empty.id);

        eTree.empty.parentList.add(aTree.finish.id);
        eTree.empty.parentList.add(bTree.finish.id);

        finish.parentList.remove(aTree.finish.id);
        finish.parentList.remove(bTree.finish.id);

        eTree.finish.childList.add(finish.id);
        finish.parentList.add(eTree.finish.id);
        eTree.rootId = rootId;

        commodityVTreeList.add(aTree);
        commodityVTreeList.add(bTree);
        commodityVTreeList.add(cTree);
        commodityVTreeList.add(dTree);
        commodityVTreeList.add(eTree);
    }
}
