package com.jaramillo;

/**
 * Designed by Cristian Omar Jaramillo Mendez
 * Visit https://github.com/CristianJaramillo/TestInteligencia for more Graphics Freebies
 * ~~https://twitter.com/CristianOmarJar~~
**/

import net.junian.kodefun.fbapp.R;
import com.easy.facebook.android.apicall.GraphApi;
import com.easy.facebook.android.data.User;
import com.easy.facebook.android.error.EasyFacebookError;
import com.easy.facebook.android.facebook.FBLoginManager;
import com.easy.facebook.android.facebook.Facebook;
import com.easy.facebook.android.facebook.LoginListener;
import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Test extends Activity implements LoginListener {
	/** Called when the activity is first created. */
	private RadioButton r, v, j;
	Button b,bp;
	TextView p1;
	RadioGroup rg;
	ImageView er,wn;
	public MediaPlayer fanfa,err;
	int i=0,cont=0;
	private FBLoginManager fbLoginManager;

	//replace it with your own Facebook App ID
	public final String KODEFUNFBAPP_ID = "303121969700700";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);		
        er=(ImageView)findViewById(R.id.loser1);        
        wn=(ImageView)findViewById(R.id.win1);
        fanfa=MediaPlayer.create(this, R.raw.fanfarrias);
        err=MediaPlayer.create(this, R.raw.falla);
    	p1=(TextView)findViewById(R.id.textView1);
    	b=(Button)findViewById(R.id.button1);
    	bp=(Button)findViewById(R.id.btnpublicar);
    	rg=(RadioGroup)findViewById(R.id.radioGroup1);
    	p1.setText("Cual es el numero que si lo pones al reves vale menos");
		r = (RadioButton) findViewById(R.id.radio0);
		v = (RadioButton) findViewById(R.id.radio1);
		j = (RadioButton) findViewById(R.id.radio2);
		r.setText("9");
		v.setText("8");
		j.setText("7");
	}
	public void Publicar(View v){		
		connectToFacebook();
	}
    public void ENVIAR(View V){       
        if(i==0){
        	if (r.isChecked()) {
				//Toast.makeText(this, "Correcto", Toast.LENGTH_SHORT).show();
				++cont;
			}
        	i++; 
    		r.setText("144");
    		v.setText("112");
    		j.setText("122");
        	p1.setText("Cuanto es 44x44");
		}       	
        if(i==1){
        	if (r.isChecked()) {
				//Toast.makeText(this, "Correcto", Toast.LENGTH_SHORT).show();
				++cont;
			}
        	i++; 
    		r.setText("D.F.");
    		v.setText("Guadalajara");
    		j.setText("Moscu");
        	p1.setText("Cual es la capital de Mexico");
		}
        else if(i==2){
        	if (r.isChecked()) {
				//Toast.makeText(this, "Correcto", Toast.LENGTH_SHORT).show();
				++cont;
			}
        	i++; 
    		r.setText("Vicente Fox");
    		v.setText("Felipe Calderon");
    		j.setText("EPN");
        	p1.setText("Come se llama el presidente de Mexico");
		}
        else if(i==3){
        	if (j.isChecked()) {
				//Toast.makeText(this, "Correcto", Toast.LENGTH_SHORT).show();
				++cont;
			}
        	i++;
    		r.setText("Cuello");
    		v.setText("Sombrero");
    		j.setText("Pelo");
        	p1.setText(" MANO es a Guante como CABEZA es a:");
		}
        else if(i==4){
        	if (r.isChecked()) {
				//Toast.makeText(this, "Correcto", Toast.LENGTH_SHORT).show();
				++cont;
			}
        	i++; 
    		r.setText("169");
    		v.setText("112");
    		j.setText("14");
        	p1.setText("Cuanto es 13x13");
		}
        else if(i==5){
        	if (r.isChecked()) {
				//Toast.makeText(this, "Correcto", Toast.LENGTH_SHORT).show();
				++cont;
			}
        	i++; 
    		r.setText("12");
    		v.setText("11");
    		j.setText("10");
        	p1.setText("Cuanto es raiz de 144");
		}
        else if(i==6){
        	if (r.isChecked()) {
				//Toast.makeText(this, "Correcto", Toast.LENGTH_SHORT).show();
				++cont;
			}
        	i++; 
    		r.setText("1");
    		v.setText("10");
    		j.setText("100");
        	p1.setText("Cuanto es X romano en decimal");
		}
        else if(i==7){        	
        	if (v.isChecked()) {
        		//Toast.makeText(this, "Correcto", Toast.LENGTH_SHORT).show();
        		++cont;
			} 
        	i++; 
    		r.setText("ISC");
    		v.setText("NO SE");
    		j.setText("NADA");
        	p1.setText("ISC o ADMIN?");
		}
        else if(i==8){
        	if (r.isChecked()) {
				//Toast.makeText(this, "Correcto", Toast.LENGTH_SHORT).show();
				++cont;
			}			 
        	i++; 
    		r.setText("Mexico");
    		v.setText("Guatemala");
    		j.setText("OK");
        	p1.setText("ENRIQUE PEÑA NIETO ES DE:");
		}
        else if(i==9){
        	if (r.isChecked()) {
				//Toast.makeText(this, "Correcto", Toast.LENGTH_SHORT).show();
				++cont;
			}
        	i++; 
        	p1.setText("Preciona Ver Resultado");
        	b.setText("Ver resultado");
        	rg.setVisibility(View.INVISIBLE);
        	bp.setVisibility(View.VISIBLE);
		}
        else{
        	cont=cont*10;
        	if (cont<=5){
        		p1.setText("Loser: "+cont);
        		err.start();
        		er.setVisibility(View.VISIBLE);
        	}
        	else if(cont>6){
        		p1.setText("Resultado: "+cont);
        		fanfa.start();
        		wn.setVisibility(View.VISIBLE);
        	}
        }
    }
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		err.stop();
		fanfa.stop();
		super.onDestroy();
	}

	public void connectToFacebook(){
		//read about Facebook Permissions here:
		//http://developers.facebook.com/docs/reference/api/permissions/
		String permissions[] = {
				"user_about_me",
				"user_activities",
				"user_birthday",
				"user_checkins",
				"user_education_history",
				"user_events",
				"user_groups",
				"user_hometown",
				"user_interests",
				"user_likes",
				"user_location",
				"user_notes",
				"user_online_presence",
				"user_photo_video_tags",
				"user_photos",
				"user_relationships",
				"user_relationship_details",
				"user_religion_politics",
				"user_status",
				"user_videos",
				"user_website",
				"user_work_history",
				"email",

				"read_friendlists",
				"read_insights",
				"read_mailbox",
				"read_requests",
				"read_stream",
				"xmpp_login",
				"ads_management",
				"create_event",
				"manage_friendlists",
				"manage_notifications",
				"offline_access",
				"publish_checkins",
				"publish_stream",
				"rsvp_event",
				"sms",
				//"publish_actions",

				"manage_pages"

		};

		fbLoginManager = new FBLoginManager(this,
				R.layout.main, 
				KODEFUNFBAPP_ID, 
				permissions);

		if(fbLoginManager.existsSavedFacebook()){
			fbLoginManager.loadFacebook();
		}
		else{
			fbLoginManager.login();
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, android.content.Intent data){
		fbLoginManager.loginSuccess(data);
	}

	public void loginSuccess(Facebook facebook) {
		GraphApi graphApi = new GraphApi(facebook);

		User user = new User();

		try{
			user = graphApi.getMyAccountInfo();

			//update your status if logged in
			graphApi.setStatus(user.getFirst_name()+" a obtenido: "+cont+" puntos en su Test de inteligencia By Cristian Jaramillo @Tere");
		} catch(EasyFacebookError e){
			Log.d("TAG: ", e.toString());
		}

		fbLoginManager.displayToast("Hey, " + user.getFirst_name() + "! se publico en tu muro!");
	}

	public void logoutSuccess() {
		fbLoginManager.displayToast("Liogin Exitoso!");
	}

	public void loginFail() {
		fbLoginManager.displayToast("Error al entrar!");
	}
}
