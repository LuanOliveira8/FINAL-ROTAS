package projeto.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NotasController {

    @GetMapping("/notas")
    public String exibirFormulario() {
        return "notasForm";
    }

    @PostMapping("/notas")
    public String calcularMedia(
            @RequestParam("nota1") double nota1,
            @RequestParam("nota2") double nota2,
            @RequestParam("nota3") double nota3,
            Model model
    ) {
        double media = (nota1 + nota2 + nota3) / 3;
        model.addAttribute("media", media);
        return "resultado";
    }
}

