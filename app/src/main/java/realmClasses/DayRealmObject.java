package realmClasses;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by aliot on 25.03.2017.
 */

public class DayRealmObject extends RealmObject {

   private RealmList<CostRealmObject>  costsList;

    public RealmList<CostRealmObject> getCostsList() {
        return costsList;
    }

    public void setCostsList(RealmList<CostRealmObject> costsList) {
        this.costsList = costsList;
    }

}
