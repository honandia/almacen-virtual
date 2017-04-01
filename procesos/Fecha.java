package procesos;

import java.util.*;


public class Fecha {
private  Date actual  = new Date ();
//  Se obtiene la hora del sistema en un formato no manejable
private  StringTokenizer parametros = new StringTokenizer ( "" + actual );
private  String dia;
private  String mes;
private  String fecha;
private  String hora;
private  String gmt;
private  String año;
private  int H;  //  Hora
private  int M;  //  Minuto
private  int S;  //  Segundos
private  String fechaCompleta;	//  Sábado, 27 de Enero de 2002





public Fecha () {
		dia		= parametros.nextToken ();
        mes		= parametros.nextToken ();
        fecha	= parametros.nextToken ();
        hora	= parametros.nextToken ();
        gmt		= parametros.nextToken ();
        año		= parametros.nextToken ();
        if ( dia.equals ( "Mon" ) ) {
                dia = "Lunes";
        }
        else if ( dia.equals ( "Tue" ) ) {
                dia = "Martes";
        }
        else if ( dia.equals ( "Wed" ) ) {
                dia = "Miércoles";
        }
        else if ( dia.equals ( "Thu" ) ) {
                dia = "Jueves";
        }
        else if ( dia.equals ( "Fri" ) ) {
                dia = "Viernes";
        }
        else if ( dia.equals ( "Sat" ) ) {
                dia = "Sábado";
        }
        else {
                dia = "Domingo";
        }
        if ( mes.equals ( "Jan" ) ) {
                mes = "01";
        }
        else if ( mes.equals ( "Feb" ) ) {
                mes = "02";
        }
        else if ( mes.equals ( "Mar" ) ) {
                mes = "03";
        }
        else if ( mes.equals ( "Apr" ) ) {
                mes = "04";
        }
        else if ( mes.equals ( "May" ) ) {
                mes = "05";
        }
        else if ( mes.equals ( "Jun" ) ) {
                mes = "06";
        }
        else if ( mes.equals ( "Jul" ) ) {
                mes = "07";
        }
        else if ( mes.equals ( "Aug" ) ) {
                mes = "08";
        }
        else if ( mes.equals ( "Sep" ) ) {
                mes = "09";
        }
        else if ( mes.equals ( "Oct" ) ) {
                mes = "10";
        }
        else if ( mes.equals ( "Nov" ) ) {
                mes = "11";
        }
        else {
                mes = "12";
        }
        obtenerHora ();
        año = ""+año.charAt ( 2 )+año.charAt ( 3 );        
}

public String obtenerFechaCompleta () {
        fechaCompleta = dia + ", " + fecha + " de " + mes + " de " + año;
        return fechaCompleta;
}

public String obtenerFecha ( String X, String Y, String Z ) {
        X = X.toUpperCase ();
        Y = Y.toUpperCase ();
        Z = Z.toUpperCase ();

        if ( X.equals ( "D" ) && Y.equals ( "M" ) && Z.equals ( "A" ) ) {
    //  dd-mm-aaaa
                return ( fecha + "/" + mes + "/" + año );
        }
        else if ( X.equals ( "A" ) && Y.equals ( "D" ) && Z.equals ( "M" ) ) {
    //   aaaa-dd-mm
                return ( año + "/" + fecha + "/" + mes );
        }
        else if ( X.equals ( "A" ) && Y.equals ( "M" ) && Z.equals ( "D" ) ) {
    //   aaaa-mm-dd
                return ( año + "/" + mes + "/" + fecha );
        }
        else if ( X.equals ( "D" ) && Y.equals ( "A" ) && Z.equals ( "M" ) ) {
    //  dd-aaaa-mm
                return ( fecha + "/" + año + "/" + mes );
        }
        else if ( X.equals ( "M" ) && Y.equals ( "D" ) && Z.equals ( "A" ) ) {
    //   mm-dd-aaaa
                return ( mes + "/" + fecha + "/" + año );
        }
        else {																		//  mm-aaaa-dd
                return ( mes + "/" + año + "/" + fecha );
        }
}

public String obtenerDia () {
        return dia;
}

public void obtenerHora () {
        StringBuffer Hora = new StringBuffer ( hora );
        char decenaHora = Hora.charAt ( 0 );
        char unidadHora = Hora.charAt ( 1 );
        char decenaMin  = Hora.charAt ( 3 );
        char unidadMin	= Hora.charAt ( 4 );
        char decenaSeg	= Hora.charAt ( 6 );
        char unidadSeg  = Hora.charAt ( 7 );

        H = ( Integer.parseInt ( "" + decenaHora ) * 10 ) + ( Integer.parseInt (
"" + unidadHora ) );
        M = ( Integer.parseInt ( "" + decenaMin  ) * 10 ) + ( Integer.parseInt (
"" + unidadMin  ) );
        S = ( Integer.parseInt ( "" + decenaSeg  ) * 10 ) + ( Integer.parseInt (
"" + unidadSeg  ) );

}



public String verHoraTotal () {
        return ( H + ":" + M + ":" + S );
}

public String verHora () {
		String h;
		if(H<10){
			if (M<10){h="0" + H + ":" + "0"+M;}
			else{h= "0" + H + ":" + M;}
		}
		else if (M<10){h=H + ":" + "0"+M;}
		else{h= H + ":" + M; }
        return (h);
}

}

