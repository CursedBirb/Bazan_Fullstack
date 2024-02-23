package controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import controllers.models.Hiragana;
import controllers.repositories.HiraganaRepository;

@Component
public class DatabaseLoader implements ApplicationRunner{

    private HiraganaRepository hiraganaRepository;

    @Autowired
    public DatabaseLoader(HiraganaRepository hiraganaRepository) {

        this.hiraganaRepository = hiraganaRepository;

    }
    
    
    public void run(ApplicationArguments args) {

        try {

            Hiragana isItFilled = hiraganaRepository.findByHiraganaRomaji("A");

            if(isItFilled == null) {

                HashMap<String, String> recordsToTable = new HashMap<String, String>(){{

                    put("qwerty","A");
                    put("qwertyu","I");
                    put("qwertyui","U");
                    put("qwertyuio","E");
                    put("qwertyuiop","O");
                    put("asdfgh","Ka");
                    put("ssdafsdef","Ki");
                    put("dfgrgvsd","Ku");
                    put("sdfsdgdf","Ke");
                    put("fgdjgff","Ko");
                    put("dfgdfgdf","Sa");
                    put("yk8tykt","Shi");
                    put("fghdfghf","Su");
                    put("tykstys","Se");
                    put("dfadjyy7","So");
                    put("eahrthr","Ta");
                    put("fgjmgret","Chi");
                    put("fdhnzdf","Tsu");
                    put("fghjfgmk","Te");
                    put("erergae","To");
                    put("rtjrktyy","Na");
                    put("dgzhdfg","Ni");
                    put("fgksxfky","Nu");
                    put("reaerty","Ne");
                    put("gtyktyky","No");
                    put("jerjher","Ha");
                    put("rkmyktky","Hi");
                    put("erjaert","Fu");
                    put("dfsdfgre","He");
                    put("gftrtte","Ho");
                    put("rjrtjryy","Ma");
                    put("rtjwrte","Mi");
                    put("fgsjfgjr","Mu");
                    put("rtjwrtr","Me");
                    put("tjrtrtwr","Mo");
                    put("fgshrrt","Ya");
                    put("rtjrtjrt","Yu");
                    put("p89oiki","Yo");
                    put("trjsrtjr","Ra");
                    put("yoeer5o","Ri");
                    put("jrtjrttr","Ru");
                    put("fduiop6","Re");
                    put("rthwrt4i","Ro");
                    put("dfhtr34","Wa");
                    put("dfgaerew","Wo");
                    put("dfheryu","N");

                }};

                for (Map.Entry<String, String> record : recordsToTable.entrySet()) {

                    String image = record.getKey();
                    String name = record.getValue();
                    Hiragana data = new Hiragana(image, name);
                    hiraganaRepository.save(data);

                }
                
            }

        } catch (Exception e) {

            e.printStackTrace();

        }

    }
    
}
