package net.houwing.services;

import net.houwing.controller.KlantDto;
import net.houwing.repository.Klant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper (componentModel = "spring")
public interface KlantMapper {

    KlantMapper INSTANCE = Mappers.getMapper( KlantMapper.class );

    KlantDto klantToKlantDto(Klant klant);
    Klant klantDtoToKlant(KlantDto klantDto);
}
