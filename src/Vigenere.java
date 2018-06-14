/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author christian
 */
public class Vigenere {
    char[][] matrice;
    String verme;       
    Vigenere()
    {
        verme="VERME";
        
        matrice=new char[26][26];
        for (int r=0;r<26;r++)
        {
            for (int c=0;c<26;c++)
            {
                int car=r+c+65;
                if(car>90)
                {
                    car=car-26;
                }
                matrice[r][c]=(char) car;
                //System.out.print(matrice[r][c]);
            }
            //System.out.println();
        }
        System.out.println("MATRICE RIEMPITA CON SUCCESSO!");
    }
    
    void decifra(String message)
    {
        String str=new String();
        String fcf=message;
        int k=0;
        int l=0;
        int v=0;
        boolean flag=false;
        for(int c=0;c<fcf.length();c++)
        {
            if(fcf.charAt(c)==(char)32)
            {
                str=str+(char)32;
                v--;
            }
            else
            {
                while(flag==false)
                {
                    if(verme.charAt(v)==matrice[0][k])
                        flag=true;
                    else
                        k++;
                }
                flag=false;
                while(flag==false)
                {
                    if(fcf.charAt(c)==matrice[l][k])
                    {
                        flag=true;
                    }else
                        l++;
                }
            }
            if(fcf.charAt(c)!=(char)32)
            {
                str=str+matrice[0][l];
            }
            //System.out.print(matrice[0][l]);
            flag=false;
            l=0;
            k=0;
            v++;
            if(v==verme.length())
                v=0;
        }
        
        System.out.println("\u001B[32m"+"Messaggio decifrato:"+str.toLowerCase()+"\u001B[32m"+"\n");
    }
    String cifra(String message)
    {
        String str=new String();
        String fch=message;
        //char spazio=" ";
        int k=0;
        for(int c=0;c<fch.length();c++,k++)
        {
            char letfch=fch.charAt(c);
            int ir=letfch-65;
            char letver=verme.charAt(k);
            int ic=letver-65;
            if(fch.charAt(c)!=(char)32)
            {
                str=str+matrice[ir][ic];
            }
            else 
            {
                str=str+" ";
                k=k-1;
            }
            if (k==verme.length()-1)
            {
                k=-1;
            }
        }
        System.out.print("\u001B[32m"+"Messaggio cifrato:"+str.toLowerCase()+"\u001B[32m"+"\n");
        return str;
    }
}
