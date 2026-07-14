var app = angular.module('myApp', ['ui.bootstrap', 'ui.calendar']);

app.controller('Ctrl', function($scope, $uibModal, $log, $compile, uiCalendarConfig) {
    $scope.teste = "Calendario";

    var medico = JSON.parse(localStorage.getItem("medico"));

    var citas = new Object();

    citas.id = medico.id;

    var array = [];
    var cita;

    $.ajax({
        
        url: "http://localhost:8080/proyectoBackend/api/citas/medico",
        type: "POST",
        contentType: "application/x-www-form-urlencoded",
        async: false,
        data: citas,
        
        success: function(data, textStatus, xhr){
            data.forEach(ele => {
                cita = {
                    id: ele.id,
                    title: ele.paciente.nombre,
                    start: new Date(ele.fecha),
                    allDay: false
                };

                array.push(cita);
            });  
        },
        
        error: function(xhr, textStatus, errorThrown){
            alert("Error con citas");
        }
    });

    $scope.events = array;

    /* event source that calls a function on every view switch */
    $scope.eventSources = [$scope.events];

    /* Render Tooltip */
    $scope.eventRender = function(event, element, view) {
        element.attr({
            'uib-tooltip': 'editar: ' + event.title,
            'tooltip-append-to-body': true
        });
        $compile(element)($scope);
    };

    $scope.alertOnEventClick = function(date, jsEvent, view, size) {
        $scope.selected = date;
        // Modal

        $scope.animationsEnabled = true;

        var modalInstance = $uibModal.open({
            animation: $scope.animationsEnabled,
            templateUrl: 'myModalContent.html',
            controller: 'ModalInstanceCtrl',
            size: size,
            resolve: {
                items: function() {
                    return $scope.selected;
                }
            }
        });

        $scope.toggleAnimation = function() {
            $scope.animationsEnabled = !$scope.animationsEnabled;
        };
        // FIM Modal

    };

    /* Change View */
    $scope.changeView = function(view, calendar) {
        uiCalendarConfig.calendars[calendar].fullCalendar('changeView', view);
    };
    $scope.renderCalender = function(calendar) {
        if (uiCalendarConfig.calendars[calendar]) {
            uiCalendarConfig.calendars[calendar].fullCalendar('render');
        }
    };

    var currentLangCode = 'es-es';
    $scope.uiConfig = {
        calendar: {
            defaultView: 'agendaWeek',
            height: "auto",
            lang: currentLangCode,
            editable: true,
            eventTextColor: '#fff',
            eventBorderColor: '#9987B5',
            eventBackgroundColor: '#9987B5',
            header: {
                left: 'title',
                center: 'month,agendaWeek,agendaDay',
                right: 'today prev,next'
            },
            eventClick: $scope.alertOnEventClick,
            eventDrop: $scope.alertOnDrop,
            eventResize: $scope.alertOnResize,
            eventRender: $scope.eventRender
        }
    };

});

app.controller('ModalInstanceCtrl', function($scope, $uibModalInstance, items) {

    $scope.nome = items.title;

    $scope.id = items.id;
    // Mudando formato como é mostrado DateTime no input
    $scope.ted = items.start;
    $scope.date = moment($scope.ted).format("DD-MM-YYYY HH:mm");
    $scope.gfExtenso = moment(items.start).format("dddd, Do MMMM YYYY, HH:mm a");
    // FIM Mudando formato como é mostrado DateTime no input

    $scope.estado = "PENDIENTE";
    $scope.anotaciones = "anotaciones";

    $scope.items = items;

    $scope.selected = {
        item: $scope.items[0]
    };

    $scope.ok = function() {
        updateCitas();
    };

    $scope.cancel = function() {
        $uibModalInstance.dismiss('cancel');
    };
});