package project.vtree;

import lombok.Data;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class ProductVTree implements Serializable {

    String id;
    List<String> parentList = new ArrayList<>();
    List<String> childList = new ArrayList<>();
    String cliqueId;
    int use = 0;

    @Override
    public String toString() {
        return "BaseBean{" +
                "id='" + id + '\'' +
                ", parentList=" + parentList +
                ", childList=" + childList +
                ", cliqueId='" + cliqueId + '\'' +
                '}';
    }

}
