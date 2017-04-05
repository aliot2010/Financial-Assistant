package realmClasses;

import android.content.Context;

import java.util.List;

import io.realm.Realm;

/**
 * Created by aliot on 26.03.2017.
 */

public class RealmObjectConstructor {
    private Realm realm;
    private RealmObjectConstructor() {}

    public RealmObjectConstructor(Context context) {
        realm = Realm.getInstance(context);
        realm.beginTransaction();
        checkDayRealmObjectCreated();
        realm.commitTransaction();
    }

    private void checkDayRealmObjectCreated(){
        if (realm.where(DayRealmObject.class).findAll().isEmpty()){
            DayRealmObject dayRealmObject = realm.createObject(DayRealmObject.class);
        }
    }

    public void setCostToDatbase(Integer cost){
        realm.beginTransaction();
        CostRealmObject currentCost = realm.createObject(CostRealmObject.class);
        currentCost.setCost(cost);
        realm.where(DayRealmObject.class).findFirst().getCostsList().add(currentCost);

        realm.commitTransaction();
    }

    public List<CostRealmObject> getDayCostList(){
        realm.beginTransaction();
        return realm.where(DayRealmObject.class).findFirst().getCostsList();
    }

    public void closeRealm(){
        realm.commitTransaction();
        realm.close();
    }
}
