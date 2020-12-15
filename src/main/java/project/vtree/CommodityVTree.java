package project.vtree;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class CommodityVTree implements Serializable {
    String rootId;
    String id;
    ProductVTree empty;
    ProductVTree finish;
    List<ProductVTree> productVTrees = new ArrayList<>();

    public CommodityVTree create(String seed, boolean needProduct) {
        //1.首先获取需要配置的商品id作为rootId
        rootId = seed + "R1234";
        id = seed + "C1234";
        //2.创建Empty节点
        empty = new ProductVTree();
        empty.cliqueId = rootId;
        //2-1 为empty节点生成id
        empty.id = seed + "E1234";

        //3.创建Finish节点
        finish = new ProductVTree();
        finish.cliqueId = rootId;
        finish.id = seed + "F1234";

        empty.childList.add(finish.id);
        finish.parentList.add(empty.id);

        DataFactory.getInstance().addProductVTree(empty);
        DataFactory.getInstance().addProductVTree(finish);
        DataFactory.getInstance().addProductVTree(empty);
        DataFactory.getInstance().addProductVTree(finish);

        if (needProduct) {
            addProduct(seed);
        }
        return this;

    }

    private void addProduct(String seed) {
        //添加A产品，产品是一个baseBean
        ProductVTree a = new ProductVTree();
        //第一个产品
        a.childList.add(finish.id);
        a.id = seed + "a1234";
        a.parentList.add(empty.id);
        empty.childList.add(a.id);
        a.cliqueId = id;
        finish.parentList.add(a.id);

        empty.childList.remove(finish.id);
        finish.parentList.remove(empty.id);


        //第二个产品
        ProductVTree b = new ProductVTree();
        b.childList.add(finish.id);
        b.id = seed + "b1234";
        b.parentList.add(empty.id);
        empty.childList.add(b.id);
        b.cliqueId = id;
        finish.parentList.add(b.id);


        //第三个产品，依赖1和2都开通后才能执行
        ProductVTree c = new ProductVTree();
        c.id = seed + "c1234";
        c.parentList.add(a.id);
        c.parentList.add(b.id);
        a.childList.clear();
        a.childList.add(c.id);
        b.childList.clear();
        b.childList.add(c.id);
        c.cliqueId = id;
        c.childList.add(finish.id);
        finish.parentList.remove(a.id);
        finish.parentList.remove(b.id);
        finish.parentList.add(c.id);

        //第四个产品，做为1的前提，但是不做为2的前提
        ProductVTree d = new ProductVTree();
        d.id = seed + "d1234";
        if (a.parentList.contains(empty.id)) {
            a.parentList.remove(empty.id);
        }
        a.parentList.add(d.id);
        d.parentList.add(empty.id);
        empty.childList.remove(a.id);
        empty.childList.add(d.id);
        d.childList.add(a.id);
        d.cliqueId = id;

        //第五个产品，依赖于1和2结束后执行
        ProductVTree e = new ProductVTree();
        e.id = seed + "e1234";
        e.parentList.add(a.id);
        e.parentList.add(b.id);
        a.childList.add(e.id);
        b.childList.add(e.id);
        e.cliqueId = id;
        e.childList.add(finish.id);
        finish.parentList.add(e.id);

        DataFactory.getInstance().addProductVTree(a);
        DataFactory.getInstance().addProductVTree(b);
        DataFactory.getInstance().addProductVTree(c);
        DataFactory.getInstance().addProductVTree(d);
        DataFactory.getInstance().addProductVTree(e);

        productVTrees.add(a);
        productVTrees.add(b);
        productVTrees.add(c);
        productVTrees.add(d);
        productVTrees.add(e);
    }
}
