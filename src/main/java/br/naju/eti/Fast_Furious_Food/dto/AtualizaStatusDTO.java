/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package br.naju.eti.Fast_Furious_Food.dto;

import br.naju.eti.Fast_Furious_Food.StatusPedido;
import jakarta.validation.constraints.NotNull;

/**
 *
 * @author sesi3dia
 */
public record AtualizaStatusDTO(
    @NotNull (message = "Status é obrigatório")
    StatusPedido status) {

}
