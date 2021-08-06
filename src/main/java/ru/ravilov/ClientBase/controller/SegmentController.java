package ru.ravilov.ClientBase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.ravilov.ClientBase.model.CarCategory;
import ru.ravilov.ClientBase.model.Segment;
import ru.ravilov.ClientBase.service.CarCategoryService;
import ru.ravilov.ClientBase.service.SegmentService;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Controller
public class SegmentController {


    private SegmentService segmentService;
    @Autowired
    public SegmentController(SegmentService segmentService) {
        this.segmentService = segmentService;
    }

    @GetMapping("/allSegments")
    public String AllSegment(Model model){

        List<Segment> segmentList = segmentService.listAll();
        model.addAttribute("segmentList",segmentList);
        return "segments";

    }

    @GetMapping("/segment/{id}")
    public String getSegmentInfo(@PathVariable Long id, Model model){

        Segment segment = segmentService.get(id);

        model.addAttribute("segment",segment);

        return "segment";
    }

    @GetMapping("/newSegment")
    public String createNewSegment(Model model){

        Segment segment = new Segment();

        model.addAttribute("segment",segment);

        return "new_segment";
    }

    @PostMapping("/saveSegment")
    public String saveCategory(@ModelAttribute("segment") Segment segment, @RequestParam("fileImage") MultipartFile multipartFile) throws IOException {

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        segment.setImage(fileName);
        Segment saveSegment = segmentService.save(segment);

        String uploadDir = "/brand-logos/" + saveSegment.getId();

        Path uploadPath = Paths.get(uploadDir);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new IOException("Could not save uploaded file: " + fileName);
        }
        return "redirect:/allSegments";
    }

    @GetMapping("/deleteSegment/{id}")
    public String deleteSegment(@PathVariable(name = "id") Long id){
        segmentService.delete(id);

        return "redirect:/allSegments";
    }
}
