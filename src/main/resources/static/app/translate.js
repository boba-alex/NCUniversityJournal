// Подключаем модуль translate
//var app = angular.module('app', ['pascalprecht.translate'])
angular.module('JWTDemoApp')
    .config(function ($translateProvider) {
        // Загружаем переводы в модуль:
        // Английский
        $translateProvider.translations('en', {
            REGISTER: 'Register',
            PROFILE: 'Profile',
            USERS: 'Users',
            HI: 'Hi',
            LOGOUT: 'Logout',
            LOGIN: 'Login',
            SUBMIT: 'Submit',
            //users
            USER: 'User',
            NAME: 'Name',
            USERNAME: 'Username',
            ROLE: 'Role',
            PASSWORD: 'Password',
            CONFIRM_PASSWORD: 'Confirm password',
            BUTTON_CREATE_USER: 'Create',
            BUTTON_UPDATE_USER: 'Update',
            USERS: 'Users',
            BUTTON_NEW_USER: 'New user',
            //create-subject
            CREATE_SUBJECT: 'Create subject',
            CREATE: 'Create',
            UPDATE: 'Update',
            NAME_OF_SUBJECT: 'Name of subject',
            //profile
            ABOUT_ME: 'About me',
            ADDRESS: 'Address',
            COUNTRY: 'Country',
            CITY: 'City',
            UNIVERSITY: 'University',
            JOB: 'Job',
            ACCESS_DENIED: 'Access Denied',
            //add-workplan
            ADD_WORKPLAN: 'Add workplan',
            NUMBER_OF_SEMESTER: 'Number of semester',
            NAME_OF_SUBJECT: 'Name of subject'


        });
        // Русский
        $translateProvider.translations('ru', {
            REGISTER: 'Регистрация',
            INSTRUCTIONS: 'Инструкции',
            PROFILE: 'Профиль',
            USERS: 'Пользователи',
            HI: 'Привет',
            LOGOUT: 'Выйти',
            LOGIN: 'Войти',
            SUBMIT: 'Подтвердить',
            //users
            USER: 'Пользователь',
            NAME: 'Имя',
            USERNAME: 'Логин',
            ROLE: 'Роль',
            PASSWORD: 'Пароль',
            CONFIRM_PASSWORD: 'Подтвердите пароль',
            BUTTON_CREATE_USER: 'Создать',
            BUTTON_UPDATE_USER: 'Обновить',
            USERS: 'Пользователи',
            BUTTON_NEW_USER: 'Новый пользователь',
            //create-subject
            CREATE_SUBJECT: 'Добавить учебный предмет',
            CREATE: 'Создать',
            UPDATE: 'Обновить',
            CREATOR: 'Создатель',
            NAME_OF_SUBJECT: 'Название учебного предмета',
            //profile
            ABOUT_ME: 'Обо мне',
            ADDRESS: 'Адрес',
            COUNTRY: 'Страна',
            CITY: 'Город',
            UNIVERSITY: 'Университет',
            JOB: 'Профессия',
            ACCESS_DENIED: 'В доступе отказано',
            //add-workplan
            ADD_WORKPLAN: 'Добавить учебный план',
            NUMBER_OF_SEMESTER: 'Номер семестра',
            NAME_OF_SUBJECT: 'Название предмета'

        });
        // Устанавливаем язык по умолчанию
        $translateProvider.preferredLanguage('en');
    })

    // Добавляем ссылку на $translate в контроллер
    .controller('TranslateController', function( $scope, $translate ){
        // Переключатель языков:
        $scope.changeLng = function( lang ) {
            $translate.use( lang );
            console.log($translate);
        };
        // Проверка текущего языка:
        $scope.currentLng = function( lang ) {
            return $translate.use() == lang;
        };
    });