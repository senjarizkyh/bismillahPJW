package data;

/**
 * Created by senjaRP on 6/26/2015.
 */

import org.json.JSONObject;

public interface JSONPopulator {
    void populate(JSONObject data);
    JSONObject toJSON();

}
