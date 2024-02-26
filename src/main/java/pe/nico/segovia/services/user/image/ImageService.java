package pe.nico.segovia.services.user.image;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import pe.nico.segovia.entities.Answer;
import pe.nico.segovia.entities.Image;
import pe.nico.segovia.repositories.IAnswerRepository;
import pe.nico.segovia.repositories.ImageRepository;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ImageService {
    private final ImageRepository imageRepository;
    private final IAnswerRepository answerRepository;

    public void storeFile(MultipartFile multipartFile, Long answerId) throws IOException{
        Optional<Answer> optionalAnswer = answerRepository.findById(answerId);

        if(optionalAnswer.isPresent()){
            String fileName = StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));
            Image image = new Image();

            image.setName(fileName);
            image.setAnswer(optionalAnswer.get());
            image.setType(multipartFile.getContentType());
            image.setData(multipartFile.getBytes());

            imageRepository.save(image);
        } else{
            throw new IOException("Answer not found!");
        }
    }
}
