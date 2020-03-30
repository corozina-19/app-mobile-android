/**
 * Role based package for generic application utilities
 * @author Rafael barboza
 */
package com.latam.covid

import android.content.ContentValues.TAG
import android.util.Log
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.iid.FirebaseInstanceId
import java.text.SimpleDateFormat
import java.util.*


@JvmOverloads fun writeDiagnostic(questions:Map<String, Any>, dbRef:String="questions"){
    /**
     * Obtain the token from the mobile and send it to the firebase databases,
     * to save it as the key of the questions parameter
     * -- Usage example Java:
     *         Map<String, String> map = new HashMap<String, String>();
     *         map.put("name", "test");
     *         writeDiagnostic(map);
     */
    FirebaseInstanceId.getInstance().instanceId
            .addOnCompleteListener(OnCompleteListener { task ->
                if (!task.isSuccessful) {
                    Log.w(TAG, "getInstanceId failed", task.exception)
                    return@OnCompleteListener
                }

                // Get new Instance ID token
                val token= task.result?.token!!
                // Set new Instance ID token for firebase db
                val database = FirebaseFirestore.getInstance()
                val sdf = SimpleDateFormat("dd_M_yyyy")
                val currentDate = sdf.format(Date())

                database.collection(dbRef).document(token).collection(currentDate)
                        .add(questions)
                        .addOnSuccessListener { documentReference ->
                            Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                        }
                        .addOnFailureListener { e ->
                            Log.w(TAG, "Error adding document", e)
                        }
            })
}

