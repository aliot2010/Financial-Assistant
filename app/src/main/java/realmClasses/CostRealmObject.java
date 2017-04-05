package realmClasses;

import io.realm.RealmObject;

/**
 * Created by aliot on 25.03.2017.
 */

public class CostRealmObject extends RealmObject {
    private Integer cost;

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }


}
