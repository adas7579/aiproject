
package ai;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;

/**
 *
 * @author aNaWorLd
 */
public class JMake {

    RequestResponse rr = new RequestResponse();

    JSONObject Login(String un, String pwd, String did) throws Exception {
        //     rr = new RequestResponse();
        JSONObject tt = rr.decodeJson(rr.postRequest("api/login", rr.encodeJSON(new String[][]{{"email", un}, {"password", pwd}, {"device_id", did}})));
        return tt;
    }

    int Reg(String[] a) {

        String[][] data = new String[][]{
            {"email", a[0]},
            {"password", a[1]},
            {"username", a[2]},
            {"fullname", a[3]},
            {"gender", a[4]},
            {"dob", a[5]}
        };
        JSONObject r = rr.encodeJSON(data);
        try {
            JSONObject tt = rr.decodeJson(rr.postRequest("api/register", r));
            if (tt.containsValue("User Registered Successfully")) {
                return 1;
            } else {
                return 0;
            }

        } catch (Exception ex) {
            Logger.getLogger(JMake.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 1;
    }

    public int RegDevice(String[] a) throws Exception {

        String[][] data = new String[][]{
            {"type", a[0]},
            {"email", a[1]},
            {"device_id", a[2]},
            {"device_name", a[3]},};
        JSONObject r = rr.encodeJSON(data);

        JSONObject tt = rr.decodeJson(rr.postRequest("api/userdevices", r));
        if (tt.containsValue("Successfully Inserted Device")) {
            return 1;
        } else {
            return 0;
        }

    }

    int Validate(String a, int i) throws Exception {
        if (i == 0) {
            //      JOptionPane.showMessageDialog(null,a+"  "+i);
            // rr=new RequestResponse();
            JSONObject tt = rr.decodeJson(rr.getRequest("api/emailcheck/" + a));
            //   JOptionPane.showMessageDialog(null,tt);
            if (tt.containsValue("Available")) {
                return 1;
            } else {
                return 0;
            }
        } else {
            JSONObject tt = rr.decodeJson(rr.getRequest("api/usernamecheck/" + a));
            if (tt.containsValue("Available")) {
                return 1;
            } else {
                return 0;
            }
        }

    }

    JSONObject Logout(String id, String did) throws Exception {
        JSONObject tt = rr.decodeJson(rr.postRequest("api/Logout", rr.encodeJSON(new String[][]{{"id", id}, {"device_id", did}})));
        return tt;
    }

    public int getOTP(String a) throws Exception {
        JSONObject tt = rr.decodeJson(rr.getRequest("api/emailverify/" + a));
        if (tt.containsValue("Otp Successfully Sent")) {
            return 1;
        } else {
            return 0;
        }
    }

    public int cnfOTP(String a[]) throws Exception {
        JSONObject tt = rr.decodeJson(rr.postRequest("api/emailverify", rr.encodeJSON(new String[][]{{"email", a[0]}, {"otp", a[1]}})));
        if (tt.containsValue("Otp Matched")) {
            return 1;
        } else {
            return 0;
        }
    }

    public int sync(String a[]) throws Exception {
        JSONObject tt = rr.decodeJson(rr.postRequest("api/synctoggle", rr.encodeJSON(new String[][]{{"id", a[0]}, {"sync", a[1]}})));
        if (tt.containsValue("Successfully Set")) {
            return 1;
        } else {
            return 0;
        }
    }

    public JSONObject[] getDevices(String a) throws Exception {
        JSONObject tt[] = rr.decodeJsonArray(rr.getRequest("api/userdevices/" + a));
        System.out.println("Devices:");
        for (int i = 0; i < tt.length; i++) {
            System.out.println(tt[i].get("type") + " " + tt[i].get("device_name") + " " + tt[i].get("device_id") + " " + tt[i].get("status"));
        }
        return tt;

    }

    public int delOTP(String a) throws Exception {
        JSONObject tt = rr.decodeJson(rr.deleteRequest("api/emailverify/" + a));
        if (tt.containsValue("File Removed")) {
            return 1;
        } else {
            return 0;
        }
    }

    public int resendOTP(String a) throws Exception {
        JSONObject tt = rr.decodeJson(rr.putRequest("api/emailverify/" + a, rr.encodeJSON(new String[][]{{"email", a}, {"otp", ""}})));
        if (tt.containsValue("Otp Successfully Sent")) {
            return 1;
        } else {
            return 0;
        }
    }

    public int forgetPWD(String a) throws Exception {
        JSONObject tt = rr.decodeJson(rr.getRequest("api/ForgotPassword/" + a));
        if (tt.containsValue("Otp Successfully Sent")) {
            return 1;
        } else {
            return 0;
        }
    }

    public int UpdateDetails(String a[]) throws Exception {
        JSONObject tt = rr.decodeJson(rr.postRequest("api/user", rr.encodeJSON(new String[][]{{"id", a[0]}, {"username", a[1]}, {"fullname", a[2]}, {"dob", a[3]}, {"gender", a[4]}, {"email", a[5]}})));
        if (tt.containsValue("Successfully Updated")) {
            return 1;
        } else {
            return 0;
        }
    }

//    public JSONObject[] getNotes(String a) throws Exception {
//        JSONObject tt[] = rr.decodeJsonArray(rr.getRequest("api/Note/" + a));
//        System.out.println("Notes:");
//        for (int i = 0; i < tt.length; i++) {
//            System.out.println(tt[i].get("type") + " " + tt[i].get("device_name") + " " + tt[i].get("device_id") + " " + tt[i].get("status"));
//        }
//        return tt;
//    }
    public JSONObject getUser(String a) throws Exception {
        JSONObject tt = rr.decodeJson(rr.getRequest("api/user/" + a));
        return tt;
    }

    public int changePWD(String a[]) throws Exception {

        JSONObject tt = rr.decodeJson(rr.putRequest("api/user/1", rr.encodeJSON(new String[][]{{"email", a[0]}, {"password", a[1]}})));
        if (tt.containsValue("Successfully Updated")) {
            return 1;
        } else {
            return 0;
        }

    }

    public int delDev(String a) throws Exception {
        JSONObject tt = rr.decodeJson(rr.deleteRequest("api/userdevices/" + a));
        if (tt.containsValue("Removed Device")) {
            return 1;
        } else {
            return 0;
        }
    }
//Syncing

    public JSONObject[] getAlarm(String a) throws Exception {
        JSONObject tt[] = rr.decodeJsonArray(rr.getRequest("api/Alarm/" + a));
        return tt;
    }

    public int InsertAlarm(String a[]) throws Exception {
        JSONObject tt = rr.decodeJson(rr.postRequest("api/Alarm", rr.encodeJSON(new String[][]{{"id", a[0]}, {"alarm_id", a[1]}, {"alarm_time", a[2]}, {"alarm_text", a[3]}})));
        if (tt.containsValue("Successfully Inserted Alarm")) {
            return 1;
        } else {
            return 0;
        }
    }

    public int changeAlarm(String a[]) throws Exception {

        JSONObject tt = rr.decodeJson(rr.putRequest("api/Alarm/1", rr.encodeJSON(new String[][]{{"id", a[0]}, {"alarm_id", a[1]}, {"alarm_time", a[2]}, {"alarm_text", a[3]}})));
        if (tt.containsValue("Successfully Updated Alarm")) {
            return 1;
        } else {
            return 0;
        }
    }

    public int deleteAlarm(String a[]) throws Exception {

        JSONObject tt = rr.decodeJson(rr.putRequest("api/Alarm/2", rr.encodeJSON(new String[][]{{"id", a[0]}, {"alarm_id", a[1]}})));
        if (tt.containsValue("Successfully Deleted Alarm")) {
            return 1;
        } else {
            return 0;
        }
    }

    ///////
    public JSONObject[] getNotes(String a) throws Exception {
        JSONObject tt[] = rr.decodeJsonArray(rr.getRequest("api/Note/" + a));
        return tt;
    }

    public int InsertNotes(String a[]) throws Exception {
        JSONObject tt = rr.decodeJson(rr.postRequest("api/Note", rr.encodeJSON(new String[][]{{"id", a[0]}, {"note_id", a[1]}, {"note_date", a[2]}, {"note_data", a[3]}})));
        if (tt.containsValue("Successfully Inserted Note")) {
            return 1;
        } else {
            return 0;
        }
    }

    public int changeNotes(String a[]) throws Exception {

        JSONObject tt = rr.decodeJson(rr.putRequest("api/Note/1", rr.encodeJSON(new String[][]{{"id", a[0]}, {"note_id", a[1]}, {"note_date", a[2]}, {"note_data", a[3]}})));
        if (tt.containsValue("Successfully Updated Note")) {
            return 1;
        } else {
            return 0;
        }
    }

    public int deleteNotes(String a[]) throws Exception {

        JSONObject tt = rr.decodeJson(rr.putRequest("api/Note/2", rr.encodeJSON(new String[][]{{"id", a[0]}, {"note_id", a[1]}})));
        if (tt.containsValue("Successfully Deleted Note")) {
            return 1;
        } else {
            return 0;
        }
    }

    /////////////////////
    public JSONObject[] getHistory(String a) throws Exception {
        JSONObject tt[] = rr.decodeJsonArray(rr.getRequest("api/Prefrence/" + a));
        return tt;
    }

    public int InsertHistory(String a[]) throws Exception {
        JSONObject tt = rr.decodeJson(rr.postRequest("api/Prefrence", rr.encodeJSON(new String[][]{{"id", a[0]}, {"pref_id", a[1]}, {"pref_para", a[2]}, {"pref_val", a[3]}})));
        if (tt.containsValue("Successfully Inserted Prefrence")) {
            return 1;
        } else {
            return 0;
        }
    }

    public int changeHistory(String a[]) throws Exception {

        JSONObject tt = rr.decodeJson(rr.putRequest("api/Prefrence/1", rr.encodeJSON(new String[][]{{"id", a[0]}, {"pref_id", a[1]}, {"pref_para", a[2]}, {"pref_val", a[3]}})));
        if (tt.containsValue("Successfully Updated Prefrence")) {
            return 1;
        } else {
            return 0;
        }
    }

    public int deleteHistory(String a[]) throws Exception {

        JSONObject tt = rr.decodeJson(rr.putRequest("api/Prefrence/2", rr.encodeJSON(new String[][]{{"id", a[0]}, {"pref_id", a[1]}})));
        if (tt.containsValue("Successfully Deleted Prefrence")) {
            return 1;
        } else {
            return 0;
        }
    }

    ////////////////
    public JSONObject[] getRem(String a) throws Exception {
        JSONObject tt[] = rr.decodeJsonArray(rr.getRequest("api/Reminder/" + a));
        return tt;
    }

    public int InsertRem(String a[]) throws Exception {
        JSONObject tt = rr.decodeJson(rr.postRequest("api/Reminder", rr.encodeJSON(new String[][]{{"id", a[0]}, {"rem_id", a[1]}, {"reminder_date", a[2]}, {"reminder_time", a[3]}, {"reminder_text", a[4]}})));
        if (tt.containsValue("Successfully Inserted Reminder")) {
            return 1;
        } else {
            return 0;
        }
    }

    public int changeRem(String a[]) throws Exception {
     System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+a[2]);
     
        JSONObject tt = rr.decodeJson(rr.putRequest("api/Reminder/1", rr.encodeJSON(new String[][]{{"id", a[0]}, {"rem_id", a[1]}, {"reminder_date", a[2]}, {"reminder_time", a[3]}, {"reminder_text", a[4]}})));
        if (tt.containsValue("Successfully Updated Reminder")) {
            return 1;
        } else {
            return 0;
        }
    }

    public int deleteRem(String a[]) throws Exception {

        JSONObject tt = rr.decodeJson(rr.putRequest("api/Reminder/2", rr.encodeJSON(new String[][]{{"id", a[0]}, {"rem_id", a[1]}})));
        if (tt.containsValue("Successfully Deleted Reminder")) {
            return 1;
        } else {
            return 0;
        }
    }

    public JSONObject aiResponse(String a) throws Exception {
        JSONObject tt = rr.decodeJson(rr.postRequest("api/aiquestion", rr.encodeJSON(new String[][]{{"question", a}})));
        return tt;
    }
    

}
