package web.service.ws.praktikum.tiga;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ViewController {
    
    @RequestMapping("/tabel")
    public String getTabel(Model model, HttpServletRequest cari){
        
        String nama_barang_dicari = cari.getParameter("barang");
        String nama_ketemu = "";
        List<String> buffer = new ArrayList<>();
        
        ArrayList<List<String>> tabel_harga = new ArrayList<>();
        ArrayList<List<String>> tabel_baru = new ArrayList<>();
        
        tabel_harga.add(Arrays.asList("Telur", "1000"));
        tabel_harga.add(Arrays.asList("Mie x", "2500"));
        tabel_harga.add(Arrays.asList("Pensil", "4500"));
        tabel_harga.add(Arrays.asList("Penggaris", "5000"));
        tabel_harga.add(Arrays.asList("Tipex", "6500"));
        
        for (int brs=0;brs<tabel_harga.size();brs++){
            buffer = tabel_harga.get(brs);
            if (buffer.toString().contains(nama_barang_dicari)){
                tabel_baru.add(tabel_harga.get(brs));
            }else { nama_ketemu="Tidak Ditemukan";}
        }
        
        
        
        model.addAttribute("tabel_baru", tabel_baru);
        model.addAttribute("barangdicari", nama_ketemu);
        return "viewTabel";
    }
    
    @RequestMapping("/data/burung")
    @ResponseBody
    public ArrayList<String> getData(){
        ArrayList<String> data = new ArrayList<>();
        
        data.add("Kakatua");
        data.add("Merpati");
        data.add("Cucak Rowo");
        
        return data;
    }
    
    @CrossOrigin
    @GetMapping (value="/data/pribadi", produces = {
        MediaType.APPLICATION_JSON_VALUE}
    )
    @ResponseBody
    public HashMap<String, String> getMinuman(){
        HashMap<String, String> map = new HashMap<>();
        map.put("nama", "Bima Bayu Saputra");
        map.put("alamat", "Kasihan");
        map.put("noktp", "657893928472");
        return map;
    }
    
    @RequestMapping("/data/cuaca")
    @ResponseBody
    public HashMap<String, Integer> getRamcu(){
        HashMap<String, Integer> map = new HashMap<>();
        map.put("suhu", 26);
        map.put("kelembaban", 30);
        map.put("tekanan", 3);
        return map;
    }
    
    @CrossOrigin
    @GetMapping(value="/data/xml", produces ={
        MediaType.APPLICATION_XML_VALUE
        }
    )
    @ResponseBody
    public ArrayList<String> getXML(Model model){
        ArrayList<String> data = new ArrayList<>();
        data.add("Kakatua");
        data.add("Merpati");
        data.add("Cucak Rowo");
        
        model.addAttribute("data", data);
        
        return data;
    }
}
