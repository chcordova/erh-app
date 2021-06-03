$(document).ready(function() {
    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    $('#table-datatable-1').DataTable({
        responsive: true,
        language: {
            "sProcessing":     "Procesando...",
            "sLengthMenu":     "Mostrar _MENU_ registros",
            "sZeroRecords":    "No se encontraron resultados",
            "sEmptyTable":     "Ningún dato disponible en esta tabla",
            "sInfo":           "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
            "sInfoEmpty":      "Mostrando registros del 0 al 0 de un total de 0 registros",
            "sInfoFiltered":   "(filtrado de un total de _MAX_ registros)",
            "sInfoPostFix":    "",
            "sSearch":         "Buscar:",
            "sUrl":            "",
            "sInfoThousands":  ",",
            "sLoadingRecords": "Cargando...",
            "oPaginate": {
                "sFirst":    "Primero",
                "sLast":     "Último",
                "sNext":     "Siguiente",
                "sPrevious": "Anterior"
            },
            "oAria": {
                "sSortAscending":  ": Activar para ordenar la columna de manera ascendente",
                "sSortDescending": ": Activar para ordenar la columna de manera descendente"
            }
        }
    });

    $('#table-datatable-2').DataTable({
        responsive: true,
        language: {
            "sProcessing":     "Procesando...",
            "sLengthMenu":     "Mostrar _MENU_ registros",
            "sZeroRecords":    "No se encontraron resultados",
            "sEmptyTable":     "Ningún dato disponible en esta tabla",
            "sInfo":           "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
            "sInfoEmpty":      "Mostrando registros del 0 al 0 de un total de 0 registros",
            "sInfoFiltered":   "(filtrado de un total de _MAX_ registros)",
            "sInfoPostFix":    "",
            "sSearch":         "Buscar:",
            "sUrl":            "",
            "sInfoThousands":  ",",
            "sLoadingRecords": "Cargando...",
            "oPaginate": {
                "sFirst":    "Primero",
                "sLast":     "Último",
                "sNext":     "Siguiente",
                "sPrevious": "Anterior"
            },
            "oAria": {
                "sSortAscending":  ": Activar para ordenar la columna de manera ascendente",
                "sSortDescending": ": Activar para ordenar la columna de manera descendente"
            }
        }
    });

    $('#table-datatable-3').DataTable({
        responsive: true,
        language: {
            "sProcessing":     "Procesando...",
            "sLengthMenu":     "Mostrar _MENU_ registros",
            "sZeroRecords":    "No se encontraron resultados",
            "sEmptyTable":     "Ningún dato disponible en esta tabla",
            "sInfo":           "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
            "sInfoEmpty":      "Mostrando registros del 0 al 0 de un total de 0 registros",
            "sInfoFiltered":   "(filtrado de un total de _MAX_ registros)",
            "sInfoPostFix":    "",
            "sSearch":         "Buscar:",
            "sUrl":            "",
            "sInfoThousands":  ",",
            "sLoadingRecords": "Cargando...",
            "oPaginate": {
                "sFirst":    "Primero",
                "sLast":     "Último",
                "sNext":     "Siguiente",
                "sPrevious": "Anterior"
            },
            "oAria": {
                "sSortAscending":  ": Activar para ordenar la columna de manera ascendente",
                "sSortDescending": ": Activar para ordenar la columna de manera descendente"
            }
        }
    });

    $('#table-datatable-4').DataTable({
        responsive: true,
        language: {
            "sProcessing":     "Procesando...",
            "sLengthMenu":     "Mostrar _MENU_ registros",
            "sZeroRecords":    "No se encontraron resultados",
            "sEmptyTable":     "Ningún dato disponible en esta tabla",
            "sInfo":           "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
            "sInfoEmpty":      "Mostrando registros del 0 al 0 de un total de 0 registros",
            "sInfoFiltered":   "(filtrado de un total de _MAX_ registros)",
            "sInfoPostFix":    "",
            "sSearch":         "Buscar:",
            "sUrl":            "",
            "sInfoThousands":  ",",
            "sLoadingRecords": "Cargando...",
            "oPaginate": {
                "sFirst":    "Primero",
                "sLast":     "Último",
                "sNext":     "Siguiente",
                "sPrevious": "Anterior"
            },
            "oAria": {
                "sSortAscending":  ": Activar para ordenar la columna de manera ascendente",
                "sSortDescending": ": Activar para ordenar la columna de manera descendente"
            }
        }
    });

    <!-- Initialize Toggle Estado-->
    $(function() {
        $('.toggle-estado').bootstrapToggle();

        if ($('#estado').val() === 'ACTIVO') {
            $('.toggle-estado').bootstrapToggle('on')
        } else {
            $('.toggle-estado').bootstrapToggle('off')
        }
        <!-- Toogle Event Propagation -->
        $('.toggle-estado').change(function() {
            $('#estado').val($(this).prop('checked') ? 'ACTIVO' : 'INACTIVO')
        })
    });

    <!-- Initialize Toggle Condicion-->
    $(function() {
        $('.toggle-condicion').bootstrapToggle();

        if ($('#condicion').val() === 'ACTIVO') {
            $('.toggle-condicion').bootstrapToggle('on')
        } else {
            $('.toggle-condicion').bootstrapToggle('off')
        }
        <!-- Toogle Event Propagation -->
        $('.toggle-condicion').change(function() {
            $('#condicion').val($(this).prop('checked') ? 'ACTIVO' : 'INACTIVO')
        })
    });

    <!-- Initialize Toggle tratamientoFarmacologicoEspecifico-->
    $(function() {
        $('.toggle-tratamientoFarmacologicoEspecifico').bootstrapToggle();

        if ($('#tratamientoFarmacologicoEspecifico').val() === 'ACTIVO') {
            $('.toggle-tratamientoFarmacologicoEspecifico').bootstrapToggle('on')
        } else {
            $('.toggle-tratamientoFarmacologicoEspecifico').bootstrapToggle('off')
        }
        <!-- Toogle Event Propagation -->
        $('.toggle-tratamientoFarmacologicoEspecifico').change(function() {
            $('#tratamientoFarmacologicoEspecifico').val($(this).prop('checked') ? 'ACTIVO' : 'INACTIVO')
        })
    });

    <!-- Initialize Toggle tratamientoFarmacologicoNoEspecifico-->
    $(function() {
        $('.toggle-tratamientoFarmacologicoNoEspecifico').bootstrapToggle();

        if ($('#tratamientoFarmacologicoNoEspecifico').val() === 'ACTIVO') {
            $('.toggle-tratamientoFarmacologicoNoEspecifico').bootstrapToggle('on')
        } else {
            $('.toggle-tratamientoFarmacologicoNoEspecifico').bootstrapToggle('off')
        }
        <!-- Toogle Event Propagation -->
        $('.toggle-tratamientoFarmacologicoNoEspecifico').change(function() {
            $('#tratamientoFarmacologicoNoEspecifico').val($(this).prop('checked') ? 'ACTIVO' : 'INACTIVO')
        })
    });

    <!-- Initialize Toggle tratamientoNoFarmacologico-->
    $(function() {
        $('.toggle-tratamientoNoFarmacologico').bootstrapToggle();

        if ($('#tratamientoNoFarmacologico').val() === 'ACTIVO') {
            $('.toggle-tratamientoNoFarmacologico').bootstrapToggle('on')
        } else {
            $('.toggle-tratamientoNoFarmacologico').bootstrapToggle('off')
        }
        <!-- Toogle Event Propagation -->
        $('.toggle-tratamientoNoFarmacologico').change(function() {
            $('#tratamientoNoFarmacologico').val($(this).prop('checked') ? 'ACTIVO' : 'INACTIVO')
        })
    });

    <!-- Initialize Toggle terapiaFisica-->
    $(function() {
        $('.toggle-terapiaFisica').bootstrapToggle();

        if ($('#terapiaFisica').val() === 'ACTIVO') {
            $('.toggle-terapiaFisica').bootstrapToggle('on')
        } else {
            $('.toggle-terapiaFisica').bootstrapToggle('off')
        }
        <!-- Toogle Event Propagation -->
        $('.toggle-terapiaFisica').change(function() {
            $('#terapiaFisica').val($(this).prop('checked') ? 'ACTIVO' : 'INACTIVO')
        })
    });

    <!-- Initialize Toggle ergoterapia-->
    $(function() {
        $('.toggle-ergoterapia').bootstrapToggle();

        if ($('#ergoterapia').val() === 'ACTIVO') {
            $('.toggle-ergoterapia').bootstrapToggle('on')
        } else {
            $('.toggle-ergoterapia').bootstrapToggle('off')
        }
        <!-- Toogle Event Propagation -->
        $('.toggle-ergoterapia').change(function() {
            $('#ergoterapia').val($(this).prop('checked') ? 'ACTIVO' : 'INACTIVO')
        })
    });

    <!-- Initialize Toggle terapiaNutricionalEspecifica-->
    $(function() {
        $('.toggle-terapiaNutricionalEspecifica').bootstrapToggle();

        if ($('#terapiaNutricionalEspecifica').val() === 'ACTIVO') {
            $('.toggle-terapiaNutricionalEspecifica').bootstrapToggle('on')
        } else {
            $('.toggle-terapiaNutricionalEspecifica').bootstrapToggle('off')
        }
        <!-- Toogle Event Propagation -->
        $('.toggle-terapiaNutricionalEspecifica').change(function() {
            $('#terapiaNutricionalEspecifica').val($(this).prop('checked') ? 'ACTIVO' : 'INACTIVO')
        })
    });

    <!-- Initialize Toggle medicinaTradicional-->
    $(function() {
        $('.toggle-medicinaTradicional').bootstrapToggle();

        if ($('#medicinaTradicional').val() === 'ACTIVO') {
            $('.toggle-medicinaTradicional').bootstrapToggle('on')
        } else {
            $('.toggle-medicinaTradicional').bootstrapToggle('off')
        }
        <!-- Toogle Event Propagation -->
        $('.toggle-medicinaTradicional').change(function() {
            $('#medicinaTradicional').val($(this).prop('checked') ? 'ACTIVO' : 'INACTIVO')
        })
    });

    <!-- Initialize Toggle medicinaAlternativa-->
    $(function() {
        $('.toggle-medicinaAlternativa').bootstrapToggle();

        if ($('#medicinaAlternativa').val() === 'ACTIVO') {
            $('.toggle-medicinaAlternativa').bootstrapToggle('on')
        } else {
            $('.toggle-medicinaAlternativa').bootstrapToggle('off')
        }
        <!-- Toogle Event Propagation -->
        $('.toggle-medicinaAlternativa').change(function() {
            $('#medicinaAlternativa').val($(this).prop('checked') ? 'ACTIVO' : 'INACTIVO')
        })
    });

    <!-- Initialize Toggle consentimientoInformado-->
    $(function() {
        $('.toggle-consentimientoInformado').bootstrapToggle();

        if ($('#consentimientoInformado').val() === 'ACTIVO') {
            $('.toggle-consentimientoInformado').bootstrapToggle('on')
        } else {
            $('.toggle-consentimientoInformado').bootstrapToggle('off')
        }
        <!-- Toogle Event Propagation -->
        $('.toggle-consentimientoInformado').change(function() {
            $('#consentimientoInformado').val($(this).prop('checked') ? 'ACTIVO' : 'INACTIVO')
        })
    });

    <!-- Initialize Toggle diagnosticoClinico-->
    $(function() {
        $('.toggle-diagnosticoClinico').bootstrapToggle();

        if ($('#diagnosticoClinico').val() === 'ACTIVO') {
            $('.toggle-diagnosticoClinico').bootstrapToggle('on')
        } else {
            $('.toggle-diagnosticoClinico').bootstrapToggle('off')
        }
        <!-- Toogle Event Propagation -->
        $('.toggle-diagnosticoClinico').change(function() {
            $('#diagnosticoClinico').val($(this).prop('checked') ? 'ACTIVO' : 'INACTIVO')
        })
    });

    <!-- Initialize Toggle diagnosticoPorGenetico-->
    $(function() {
        $('.toggle-diagnosticoPorGenetico').bootstrapToggle();

        if ($('#diagnosticoPorGenetico').val() === 'ACTIVO') {
            $('.toggle-diagnosticoPorGenetico').bootstrapToggle('on')
        } else {
            $('.toggle-diagnosticoPorGenetico').bootstrapToggle('off')
        }
        <!-- Toogle Event Propagation -->
        $('.toggle-diagnosticoPorGenetico').change(function() {
            $('#diagnosticoPorGenetico').val($(this).prop('checked') ? 'ACTIVO' : 'INACTIVO')
        })
    });

    <!-- Initialize Toggle diagnosticoBioquimico-->
    $(function() {
        $('.toggle-diagnosticoBioquimico').bootstrapToggle();

        if ($('#diagnosticoBioquimico').val() === 'ACTIVO') {
            $('.toggle-diagnosticoBioquimico').bootstrapToggle('on')
        } else {
            $('.toggle-diagnosticoBioquimico').bootstrapToggle('off')
        }
        <!-- Toogle Event Propagation -->
        $('.toggle-diagnosticoBioquimico').change(function() {
            $('#diagnosticoBioquimico').val($(this).prop('checked') ? 'ACTIVO' : 'INACTIVO')
        })
    });

    <!-- Initialize Toggle diagnosticoPorImagenes-->
    $(function() {
        $('.toggle-diagnosticoPorImagenes').bootstrapToggle();

        if ($('#diagnosticoPorImagenes').val() === 'ACTIVO') {
            $('.toggle-diagnosticoPorImagenes').bootstrapToggle('on')
        } else {
            $('.toggle-diagnosticoPorImagenes').bootstrapToggle('off')
        }
        <!-- Toogle Event Propagation -->
        $('.toggle-diagnosticoPorImagenes').change(function() {
            $('#diagnosticoPorImagenes').val($(this).prop('checked') ? 'ACTIVO' : 'INACTIVO')
        })
    });

    <!-- Initialize Toggle diagnosticoInmunologico-->
    $(function() {
        $('.toggle-diagnosticoInmunologico').bootstrapToggle();

        if ($('#diagnosticoInmunologico').val() === 'ACTIVO') {
            $('.toggle-diagnosticoInmunologico').bootstrapToggle('on')
        } else {
            $('.toggle-diagnosticoInmunologico').bootstrapToggle('off')
        }
        <!-- Toogle Event Propagation -->
        $('.toggle-diagnosticoInmunologico').change(function() {
            $('#diagnosticoInmunologico').val($(this).prop('checked') ? 'ACTIVO' : 'INACTIVO')
        })
    });

    <!-- Initialize Toggle familiarCondicion-->
    $(function() {
        $('.toggle-familiarCondicion').bootstrapToggle();

        if ($('#familiarCondicion').val() === 'ACTIVO') {
            $('.toggle-familiarCondicion').bootstrapToggle('on')
        } else {
            $('.toggle-familiarCondicion').bootstrapToggle('off')
        }
        <!-- Toogle Event Propagation -->
        $('.toggle-familiarCondicion').change(function() {
            $('#familiarCondicion').val($(this).prop('checked') ? 'ACTIVO' : 'INACTIVO')
        })
    });

    <!-- Initialize Toggle mismaEnfermedad-->
    $(function() {
        $('.toggle-mismaEnfermedad').bootstrapToggle();

        if ($('#mismaEnfermedad').val() === 'ACTIVO') {
            $('.toggle-mismaEnfermedad').bootstrapToggle('on')
        } else {
            $('.toggle-mismaEnfermedad').bootstrapToggle('off')
        }
        <!-- Toogle Event Propagation -->
        $('.toggle-mismaEnfermedad').change(function() {
            $('#mismaEnfermedad').val($(this).prop('checked') ? 'ACTIVO' : 'INACTIVO')
        })
    });

    <!-- Initialize Toggle laboraActualmente-->
    $(function() {
        $('.toggle-laboraActualmente').bootstrapToggle();

        if ($('#laboraActualmente').val() === 'ACTIVO') {
            $('.toggle-laboraActualmente').bootstrapToggle('on')
        } else {
            $('.toggle-laboraActualmente').bootstrapToggle('off')
        }
        <!-- Toogle Event Propagation -->
        $('.toggle-laboraActualmente').change(function() {
            $('#laboraActualmente').val($(this).prop('checked') ? 'ACTIVO' : 'INACTIVO')
        })
    });

    <!-- Initialize Toggle limitacionFuncional-->
    $(function() {
        $('.toggle-limitacionFuncional').bootstrapToggle();

        if ($('#limitacionFuncional').val() === 'ACTIVO') {
            $('.toggle-limitacionFuncional').bootstrapToggle('on')
        } else {
            $('.toggle-limitacionFuncional').bootstrapToggle('off')
        }
        <!-- Toogle Event Propagation -->
        $('.toggle-limitacionFuncional').change(function() {
            $('#limitacionFuncional').val($(this).prop('checked') ? 'ACTIVO' : 'INACTIVO')
        })
    });

    <!-- Initialize Toggle inscritoConadis-->
    $(function() {
        $('.toggle-inscritoConadis').bootstrapToggle();

        if ($('#inscritoConadis').val() === 'ACTIVO') {
            $('.toggle-inscritoConadis').bootstrapToggle('on')
        } else {
            $('.toggle-inscritoConadis').bootstrapToggle('off')
        }
        <!-- Toogle Event Propagation -->
        $('.toggle-inscritoConadis').change(function() {
            $('#inscritoConadis').val($(this).prop('checked') ? 'ACTIVO' : 'INACTIVO')
        })
    });

    <!-- Radio Options Reset-->
    $(function() {
        $(".rdoption").click(function(){
            $(".rdoption").prop("checked", false);
        });
    });

});

<!-- Select Ipress Event -->
function checkIpress(id, nombre) {
    $('input[id="ipress.id"]').val(id);
    $('input[id="ipress.nombre"]').val(nombre);
    $('#ipressModal').modal('hide');
}

<!-- Select Disitrito Nacimiento Event -->
function checkDistritoNacimiento(id, nombre) {
    $('input[id="distritoNacimiento.id"]').val(id);
    $('input[id="distritoNacimiento.nombre"]').val(nombre);
    $('#distritoNacimientoModal').modal('hide');
}

<!-- Select Disitrito Residencia Event -->
function checkDistritoResidencia(id, nombre) {
    $('input[id="distritoResidencia.id"]').val(id);
    $('input[id="distritoResidencia.nombre"]').val(nombre);
    $('#distritoResidenciaModal').modal('hide');
}

<!-- Select Medico Event -->
function checkMedico(id, nombre, apePaterno, apeMaterno, especialidad, cmp) {

    let info = nombre + ' ' + apePaterno + ' ' + apeMaterno;
    $('input[id="txtMedicoInfo"]').val(info);

    $('input[id="medico.id"]').val(id);
    $('input[id="medico.especialidad"]').val(especialidad);
    $('input[id="medico.cmp"]').val(cmp);

    $('#medicoModal').modal('hide');
}

<!-- Select Cie10 Event -->
function checkCie10(id, codigo, nombre) {
    $('input[id="cie10Carpeta.id"]').val(id);
    $('input[id="cie10Carpeta.codigo"]').val(codigo);
    $('input[id="cie10Carpeta.nombre"]').val(nombre);
    $('#cie10Modal').modal('hide');
}

<!-- Select Orphanet Event -->
function checkOrphanet(id, nombre) {
    $('input[id="orphanet.id"]').val(id);
    $('input[id="orphanet.nombre"]').val(nombre);
    $('#orphanetModal').modal('hide');
}







