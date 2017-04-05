package realmClasses;

import android.content.Context;

import java.util.List;

import io.realm.Realm;

/**
 * Created by aliot on 26.03.2017.
 */

public class RealmObjectConstructor {

    private Context context;
    private Realm realm;
    private RealmObjectConstructor() {}

    public RealmObjectConstructor(Context context) {
        //this.context = context;
        realm = Realm.getInstance(context);
    }

    public void setCostToDatbase(Integer cost){
        realm.beginTransaction();
        CostRealmObject currentCost = realm.createObject(CostRealmObject.class);
        currentCost.setCost(cost);
        if (realm.where(DayRealmObject.class).findAll().isEmpty()){
            DayRealmObject dayRealmObject = realm.createObject(DayRealmObject.class);
            dayRealmObject.getCostsList().add(currentCost);
        } else {
            realm.where(DayRealmObject.class).findFirst().getCostsList().add(currentCost);
        }

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
